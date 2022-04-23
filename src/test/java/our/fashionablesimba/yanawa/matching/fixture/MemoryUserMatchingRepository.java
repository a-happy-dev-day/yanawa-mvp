package our.fashionablesimba.yanawa.matching.fixture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryUserMatchingRepository implements UserMatchingRepository {

    Map<Long, UserMatching> userMatchings = new HashMap<>();

    private static Long sequence = 0L;

    @Override
    public UserMatching save(UserMatching userMatching) {
        Long id = ++sequence;
        UserMatching saveUserMatching = new UserMatching(id, userMatching.getUserId(), userMatching.getMatchingId(), userMatching.getUserMatchingStatus());
        userMatchings.put(id, saveUserMatching);
        return saveUserMatching;
    }

    @Override
    public List<UserMatching> findAllByMatchingId(Long matchingId) {
        return userMatchings.values().stream()
                .filter(userMatching -> userMatching.getMatchingId().equals(matchingId))
                .collect(Collectors.toList());
    }

}
