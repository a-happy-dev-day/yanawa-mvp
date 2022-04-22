package our.fashionablesimba.yanawa.matching.domain.matchingreview;

import java.util.List;
import java.util.Optional;

public interface MatchingReviewRepository {
    MatchingReview save(MatchingReview matchingReview);

    Optional<MatchingReview> findById(Long matchingReviewId);

    List<MatchingReview> findByMatchingId(Long matchingId);
}
