package our.fashionablesimba.yanawa.matching.domain.matching;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MatchingRepository {
    Matching save(Matching matching);

    Optional<Matching> findById(Long matchingId);

    List<Matching> findAllByUserId(Long userId);

    List<Matching> findAll();
}
