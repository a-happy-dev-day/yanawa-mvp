package our.fashionablesimba.yanawa.matching.domain.usermatching;

public class UserMatching {
    private Long userMatchingId;
    private Long userId;
    private Long matchingId;
    private UserMatchingStatus userMatchingStatus;

    protected UserMatching() {/*no-op*/}

    private UserMatching(Long userMatchingId, Long userId, Long matchingId, UserMatchingStatus userMatchingStatus) {
        this.userMatchingId = userMatchingId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.userMatchingStatus = userMatchingStatus;
    }

    public UserMatching(Long userMatchingId, Long userId, Long matchingId) {
        this(userMatchingId, userId, matchingId, UserMatchingStatus.ACCEPTED);
    }

    public Long getUserMatchingId() {
        return userMatchingId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMatchingId() {
        return matchingId;
    }

    public UserMatchingStatus getUserMatchingStatus() {
        return userMatchingStatus;
    }
}
