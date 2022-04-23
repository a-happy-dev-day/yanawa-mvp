package our.fashionablesimba.yanawa.matching.dto;

import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;

public class ReviewResponse {
    private final Long userId;
    private final Long partnerId;
    private final int userScore;
    private final int partnerScore;
    private final String review;

    public ReviewResponse(Long userId, Long partnerId, int userScore, int partnerScore, String review) {
        this.userId = userId;
        this.partnerId = partnerId;
        this.userScore = userScore;
        this.partnerScore = partnerScore;
        this.review = review;
    }

    public ReviewResponse(MatchingReview review) {
        this(review.getUserId(), review.getPartnerId(), review.getUserScore(), review.getPartnerScore(), review.getReview());
    }

    public Long getUserId() {
        return userId;
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
}
