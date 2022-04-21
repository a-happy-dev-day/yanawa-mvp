package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryMatchingRepository implements MatchingRepository {

    List<Matching> matchings = new ArrayList<>();

    private static Long sequence = 0L;
    @Override
    public Matching save(Matching matching) {

        Matching saveMatching = new Matching(++sequence, matching.getUserId(), matching.getCreationDate(), matching.getMatchingDate(),
                matching.getTennisCourtName(), matching.getNumberOfMember(), matching.getMinimumLevel(),
                matching.getMaximumLevel(), matching.getRecruitmentAge(),
                matching.getPreferenceTeamGame(), matching.getRentalCost(),
                matching.getStatus(), matching.getRecruitmentAnnual(), matching.getMatchingContent());

        matchings.add(saveMatching);
        return saveMatching;
    }

    @Override
    public Optional<Matching> findById(Long matchingId) {
        return matchings.stream()
                .filter(matching -> matching.getMatchingId().equals(matchingId))
                .findFirst();
    }

    @Override
    public List<Matching> findAllByUserId(Long userId) {
        return matchings.stream()
                .filter(matching -> matching.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Matching> findAll() {
        return matchings;
    }
}
