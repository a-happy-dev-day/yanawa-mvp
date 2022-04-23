package our.fashionablesimba.yanawa.matching.domain.matchingreview;

public class MatchingReview {
    private Long reviewId;
    private Long userId;
    private Long matchingId;
    private Long partnerId;
    private int userScore;
    private int partnerScore;
    private String review;


    protected MatchingReview() {/*no-op*/}

    public MatchingReview(Long reviewId, Long userId, Long matchingId, Long partnerId, int userScore, int partnerScore, String review) {

        if (partnerScore < 0 || userScore < 0) {
            throw new IllegalArgumentException("점수에는 음수가 들어갈 수 없습니다.");
        }

        if (userId == partnerId) {
            throw new IllegalArgumentException("자신과 파트너가 같은 아이디를 가지고 있습니다.");
        }

        this.reviewId = reviewId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.partnerId = partnerId;
        this.partnerScore = partnerScore;
        this.userScore = userScore;
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

    public int getUserScore() {
        return userScore;
    }

    public int getPartnerScore() {
        return partnerScore;
    }

    public String getReview() {
        return review;
    }

    public Long getPartnerId() {
        return partnerId;
    }
}
