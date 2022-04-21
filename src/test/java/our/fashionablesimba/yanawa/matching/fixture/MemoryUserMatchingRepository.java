package our.fashionablesimba.yanawa.matching.fixture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryUserMatchingRepository implements UserMatchingRepository {

    List<UserMatching> userMatchings = new ArrayList<>();

    private static Long sequence = 0L;

    @Override
    public UserMatching save(UserMatching userMatching) {
        UserMatching saveUserMatching = new UserMatching(++sequence, userMatching.getUserId(), userMatching.getMatchingId(), userMatching.getUserMatchingStatus());
        userMatchings.add(saveUserMatching);
        return saveUserMatching;
    }

    @Override
    public List<UserMatching> findAllByMatchingId(Long matchingId) {
        return userMatchings.stream()
                .filter(userMatching -> userMatching.getMatchingId().equals(matchingId))
                .collect(Collectors.toList());
    }

}
