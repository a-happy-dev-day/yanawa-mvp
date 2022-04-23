package our.fashionablesimba.yanawa.matching.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingStatus;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReviewRepository;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.NotificationReviewClient;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;
import our.fashionablesimba.yanawa.matching.error.NotFoundDataException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchingReviewService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private final MatchingRepository matchingRepository;
    private final MatchingReviewRepository matchingReviewRepository;



    public MatchingReviewService(MatchingRepository matchingRepository, MatchingReviewRepository matchingReviewRepository) {
        this.matchingRepository = matchingRepository;
        this.matchingReviewRepository = matchingReviewRepository;
    }

    public MatchingReview review(MatchingReview matchingReview) {

        Matching matching = matchingRepository
                .findById(matchingReview.getMatchingId())
                .orElseThrow(() -> new NotFoundDataException("메칭이 존재하지 않습니다."));

        if (matching.getStatus() != MatchingStatus.MATCHING_COMPLETED) {
            throw new IllegalStateException("매칭이 완료되지 않았습니다.");
        }

        if (LocalDateTime.now().plusMinutes(10L).isAfter(matching.getMatchingDate())) {
            throw new IllegalStateException("매칭이 시작된지 10분 밖에 지나지 않았습니다.");
        }

        matching.updateStatus(MatchingStatus.REVIEW_COMPLETED);
        matchingRepository.save(matching);

        return matchingReviewRepository.save(matchingReview);
    }

    public List<MatchingReview> findMyReview(Long userId) {
        return matchingReviewRepository.findByUserId(userId);
    }
}
