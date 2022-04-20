package our.fashionablesimba.yanawa.matching.domain.usermatching;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserMatching {
    @Id
    @GeneratedValue
    private Long userMatchingId;
    private Long userId;
    private Long matchingId;
    @Enumerated
    private UserMatchingStatus userMatchingStatus;

    protected UserMatching() {/*no-op*/}

    public UserMatching(Long userMatchingId, Long userId, Long matchingId, UserMatchingStatus userMatchingStatus) {
        this.userMatchingId = userMatchingId;
        this.userId = userId;
        this.matchingId = matchingId;
        this.userMatchingStatus = userMatchingStatus;
    }

    public UserMatching(Long userId, Long matchingId) {
        this(null, userId, matchingId, UserMatchingStatus.ACCEPTED);
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
