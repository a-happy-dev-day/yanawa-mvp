package our.fashionablesimba.yanawa.matching.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import our.fashionablesimba.yanawa.matching.dto.ReviewRequest;
import our.fashionablesimba.yanawa.matching.dto.ReviewResponse;
import our.fashionablesimba.yanawa.matching.service.MatchingReviewService;

import java.util.List;
import java.util.stream.Collectors;

@RestController("api/matching/review")
public class MatchingReviewController {

    private final MatchingReviewService matchingReviewService;

    public MatchingReviewController(MatchingReviewService matchingReviewService) {
        this.matchingReviewService = matchingReviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> writeReview(ReviewRequest request) {
        return ResponseEntity.ok(
                new ReviewResponse(matchingReviewService.review(request.toMatching()))
        );
    }

    @GetMapping("{userId}")
    public ResponseEntity<List<ReviewResponse>> findMyReview(Long userId) {
        return ResponseEntity.ok(
                matchingReviewService.findMyReview(userId).stream()
                        .map(ReviewResponse::new)
                        .collect(Collectors.toList())
        );
    }
}
