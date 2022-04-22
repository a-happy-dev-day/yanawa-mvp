package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReviewRepository;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryMatchingReviewRepository implements MatchingReviewRepository {

    Map<Long, MatchingReview> reviewMap = new HashMap<>();

    private static long sequence = 0L;


    @Override
    public MatchingReview save(MatchingReview matchingReview) {
        Long id = ++sequence;
        MatchingReview review = new MatchingReview(id, matchingReview.getUserId(), matchingReview.getMatchingId(), matchingReview.getScore(), matchingReview.getReview());
        reviewMap.put(id, review);
        return review;
    }

    @Override
    public Optional<MatchingReview> findById(Long matchingReviewId) {
        return Optional.ofNullable(reviewMap.get(matchingReviewId));
    }

    @Override
    public List<MatchingReview> findByMatchingId(Long matchingId) {
        return reviewMap.values().stream().filter(matchingReview -> matchingReview.getMatchingId().equals(matchingId)).collect(Collectors.toList());
    }
}
