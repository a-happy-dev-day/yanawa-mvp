package our.fashionablesimba.yanawa.matching.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;

import java.util.List;

@Repository

public interface JpaUserMatchingRepository extends JpaRepository<UserMatching, Long>, UserMatchingRepository {
    @Override
    UserMatching save(UserMatching entity);

    List<UserMatching> findAllByMatchingId(Long matchingId);
}
