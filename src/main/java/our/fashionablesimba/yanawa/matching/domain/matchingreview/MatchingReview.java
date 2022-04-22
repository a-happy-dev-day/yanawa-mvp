package our.fashionablesimba.yanawa.matching.domain.matchingreview;

public class MatchingReview {
    private Long reviewId;
    private Long userId;
    private Long matchingId;
    private int score;
    private String review;

    protected MatchingReview() {/*no-op*/}

    public MatchingReview(Long reviewId, Long userId, Long matchingId, int score, String review) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }
}
