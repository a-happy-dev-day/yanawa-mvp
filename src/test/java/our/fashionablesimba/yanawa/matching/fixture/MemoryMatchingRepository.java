package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryMatchingRepository implements MatchingRepository {

    Map<Long, Matching> matchings = new HashMap<>();

    private static Long sequence = 0L;
    @Override
    public Matching save(Matching matching) {

        Long id = ++sequence;
        Matching saveMatching = new Matching(id, matching.getUserId(), matching.getCreationDate(), matching.getMatchingDate(),
                matching.getTennisCourtName(), matching.getNumberOfMember(), matching.getMinimumLevel(),
                matching.getMaximumLevel(), matching.getRecruitmentAge(),
                matching.getPreferenceTeamGame(), matching.getRentalCost(),
                matching.getStatus(), matching.getRecruitmentAnnual(), matching.getMatchingContent());

        matchings.put(id, saveMatching);
        return saveMatching;
    }

    @Override
    public Optional<Matching> findById(Long matchingId) {
        return matchings.values().stream()
                .filter(matching -> matching.getMatchingId().equals(matchingId))
                .findFirst();
    }

    @Override
    public List<Matching> findAllByUserId(Long userId) {
        return matchings.values().stream()
                .filter(matching -> matching.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Matching> findAll() {
        return matchings.values().stream().collect(Collectors.toList());
    }
}
