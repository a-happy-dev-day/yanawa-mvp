package our.fashionablesimba.yanawa.matching.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAMatchingRepository extends JpaRepository<Matching, Long>, MatchingRepository {
    Matching save(Matching entity);

    @Override
    Optional<Matching> findById(Long matchingId);

    List<Matching> findAllByUserId(Long userId);

    @Override
    List<Matching> findAll();
}
