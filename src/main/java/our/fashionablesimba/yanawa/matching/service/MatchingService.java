package our.fashionablesimba.yanawa.matching.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.NotificationReviewClient;
import our.fashionablesimba.yanawa.matching.domain.matching.*;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;
import our.fashionablesimba.yanawa.matching.exception.NotFoundMatchingException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Service
public class MatchingService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final MatchingRepository matchingRepository;
    private final UserMatchingRepository userMatchingRepository;
    private final NotificationReviewClient matchingReviewClient;

    public MatchingService(MatchingRepository matchingRepository, UserMatchingRepository userMatchingRepository, NotificationReviewClient matchingReviewClient) {
        this.matchingRepository = matchingRepository;
        this.userMatchingRepository = userMatchingRepository;
        this.matchingReviewClient = matchingReviewClient;
    }


    @Transactional(readOnly = true)
    public Matching findMatching(Long matchingId) {
        return matchingRepository.findById(matchingId).orElseThrow(NotFoundMatchingException::new);
    }

    @Transactional
    public Matching recruit(Matching request) {
        log.debug("[{}][{}] recruit Matching", this.getClass(), this.getClass().getSimpleName());

        matchingRepository.findAllByUserId(request.getUserId()).stream().anyMatch(matching ->
        {
            if (matching.getMatchingDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
                    .equals(request.getMatchingDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)))) {
                throw new IllegalStateException("겹치는 시간이 존재합니다.");
            }
            return false;
        });

        return matchingRepository.save(request);
    }

    @Transactional
    public UserMatching apply(Long userId, Long matchingId) {
        log.debug("[{}][{}] apply Matching", this.getClass(), this.getClass().getSimpleName());
        Matching matching = matchingRepository.findById(matchingId)
                .orElseThrow(NotFoundMatchingException::new);
        if (!matching.getStatus().equals(MatchingStatus.RECRUITING)) {
            throw new IllegalStateException("현재 매칭이 모집중이 아닙니다.");
        }

        if (userMatchingRepository.findAllByMatchingId(matchingId)
                .stream().anyMatch(userMatching -> userMatching.getUserId().equals(userId))) {
            throw new IllegalStateException("이미 신청한 매칭입니다.");
        }

        UserMatching userMatching = userMatchingRepository.save(new UserMatching(userId, matchingId));

        if (callCurrentNumberOfMember(matchingId) > callNumberOfMember(matchingId)) {
            throw new IllegalStateException("모집 정원 초가합니다.");
        }
        completeRecruitment(matchingId);
        return userMatching;
    }

    @Transactional
    public void completeRecruitment(Long matchingId) {
        Matching matching = matchingRepository.findById(matchingId)
                .orElseThrow(NotFoundMatchingException::new);
        if (!matching.getStatus().equals(MatchingStatus.RECRUITING)) {
            throw new IllegalStateException("현재 매칭이 모집중이 아닙니다.");
        }

        matching.updateStatus(MatchingStatus.RECRUITMENT_COMPLETED);
        matchingRepository.save(matching);
    }

    @Transactional
    public void proceedMatch(Long matchingId) {
        Matching matching = matchingRepository.findById(matchingId)
                .orElseThrow(NotFoundMatchingException::new);
        if (!matching.getStatus().equals(MatchingStatus.RECRUITMENT_COMPLETED)) {
            throw new IllegalStateException("현재 매칭이 모집이 완료되지 않았습니다.");
        }

        matching.updateStatus(MatchingStatus.MATCHING_PROGRESS);
        matchingRepository.save(matching);
    }

    @Transactional
    public void completeMatch(Long matchingId) {
        Matching matching = matchingRepository.findById(matchingId)
                .orElseThrow(NotFoundMatchingException::new);
        if (!isProgress(matching)) {
            throw new IllegalStateException("현재 매칭이 진행중이지 않습니다.");
        }
        //매칭 후기 작성하라
        userMatchingRepository.findAllByMatchingId(matchingId)
                .forEach(userMatching -> {
                    matchingReviewClient.noticeMatchingReview(matchingId, userMatching.getUserId());
                });

        matching.updateStatus(MatchingStatus.MATCHING_COMPLETED);
        matchingRepository.save(matching);

    }

    @Transactional
    public void completeReview(Long matchingId) {
        Matching matching = matchingRepository.findById(matchingId)
                .orElseThrow(NotFoundMatchingException::new);
        if (!matching.getStatus().equals(MatchingStatus.MATCHING_COMPLETED)) {
            throw new IllegalStateException("현재 매칭이 끝나지 않았습니다.");
        }

        matching.updateStatus(MatchingStatus.REVIEW_COMPLETED);
        matchingRepository.save(matching);
    }

    @Transactional(readOnly = true)
    public List<Matching> findAll() {
        return matchingRepository.findAll();
    }

    @Scheduled(fixedDelayString = "${fixed.delay.seconds:60}000")
    public void CallToCompleteMatching() {
        log.debug("[{}][{}] Call to complete matching", this.getClass(), this.getClass().getSimpleName());
        matchingRepository.findAll().forEach(matching -> {
            if (isProgress(matching) && isAfterFourHour(matching)) {
                completeMatch(matching.getMatchingId());
            }
        });
    }

    private boolean isProgress(Matching matching) {
        return matching.getStatus().equals(MatchingStatus.MATCHING_PROGRESS);
    }

    private boolean isAfterFourHour(Matching matching) {
        return matching.getMatchingDate().plusHours(4).isAfter(LocalDateTime.now());
    }

    private int callNumberOfMember(Long matchingId) {
        return matchingRepository.findById(matchingId).orElseThrow(NotFoundMatchingException::new).getNumberOfMember() + 1;
    }

    private int callCurrentNumberOfMember(Long matchingId) {
        return userMatchingRepository.findAllByMatchingId(matchingId).size();
    }

}
