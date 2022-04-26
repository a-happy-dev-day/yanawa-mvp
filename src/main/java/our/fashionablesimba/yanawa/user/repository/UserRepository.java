package our.fashionablesimba.yanawa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(Email email);

    boolean existsByEmail(Email email);

    boolean existsByNickname(String nickname);

}
