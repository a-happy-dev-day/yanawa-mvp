package our.fashionablesimba.yanawa.matching.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;

@ApiModel(value = "리뷰 상세 정보")
public class ReviewDto {
    @ApiModelProperty(value = "리뷰 PK")
    private Long reviewId;
    @ApiModelProperty(value = "사용자 PK")
    private Long userId;
    @ApiModelProperty(value = "매칭 PK")
    private Long matchingId;
    @ApiModelProperty(value = "상대방의 PK")
    private Long partnerId;
    @ApiModelProperty(value = "사용자 점수")
    private int userScore;
    @ApiModelProperty(value = "상대방 점수")
    private int partnerScore;
    @ApiModelProperty(value = "리뷰")
    private String review;

    protected ReviewDto() {/*no-op*/}

    public ReviewDto(Long reviewId, Long userId, Long matchingId, Long partnerId, int userScore, int partnerScore, String review) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.partnerId = partnerId;
        this.userScore = userScore;
        this.partnerScore = partnerScore;
        this.review = review;
    }

    public ReviewDto(MatchingReview review) {
        this(review.getReviewId(), review.getUserId(), review.getMatchingId(), review.getPartnerId(),
                review.getUserScore(), review.getPartnerScore(), review.getReview());
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMatchingId() {
        return matchingId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getPartnerScore() {
        return partnerScore;
    }

    public String getReview() {
        return review;
    }

    public MatchingReview toMatching() {
        return new MatchingReview(this.reviewId, this.userId, this.matchingId, this.partnerId,
                this.userScore, this.partnerScore, this.review);
    }
}
