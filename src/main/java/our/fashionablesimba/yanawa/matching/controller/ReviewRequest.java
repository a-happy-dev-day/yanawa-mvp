package our.fashionablesimba.yanawa.matching.controller;

import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;

public class ReviewRequest {
    private Long reviewId;
    private Long userId;
    private Long matchingId;
    private Long partnerId;
    private int userScore;
    private int partnerScore;
    private String review;

    protected ReviewRequest() {/*no-op*/}

    public ReviewRequest(Long reviewId, Long userId, Long matchingId, Long partnerId, int userScore, int partnerScore, String review) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.partnerId = partnerId;
        this.userScore = userScore;
        this.partnerScore = partnerScore;
        this.review = review;
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
