package our.fashionablesimba.yanawa.matching.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReviewRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMatchingReviewRepository extends JpaRepository<MatchingReview, Long>, MatchingReviewRepository {
    @Override
    MatchingReview save(MatchingReview matchingReview);

    @Override
    Optional<MatchingReview> findById(Long matchingReviewId);

    List<MatchingReview> findByMatchingId(Long matchingId);
}
