package our.fashionablesimba.yanawa.matching.domain.usermatching;

import java.util.List;

public interface UserMatchingRepository {
    UserMatching save(UserMatching userMatching);

    List<UserMatching> findAllByMatchingId(Long matchingId);
}
