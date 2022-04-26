package our.fashionablesimba.yanawa.matching.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import our.fashionablesimba.yanawa.matching.dto.ReviewDto;
import our.fashionablesimba.yanawa.matching.service.MatchingReviewService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/matching/review")
@Api(tags = "MATCHING REVIEW APIs")
public class MatchingReviewController {

    private final MatchingReviewService matchingReviewService;

    public MatchingReviewController(MatchingReviewService matchingReviewService) {
        this.matchingReviewService = matchingReviewService;
    }

    @PostMapping
    @ApiOperation(value = "리뷰 작성")
    public ResponseEntity<ReviewDto> writeReview(ReviewDto request) {
        return ResponseEntity.ok(
                new ReviewDto(matchingReviewService.review(request.toMatching()))
        );
    }

    @GetMapping("{userId}")
    @ApiOperation(value = "자신의 리뷰 리스트 가져오기")
    public ResponseEntity<List<ReviewDto>> findMyReview(Long userId) {
        return ResponseEntity.ok(
                matchingReviewService.findMyReview(userId).stream()
                        .map(ReviewDto::new)
                        .collect(Collectors.toList())
        );
    }
}
