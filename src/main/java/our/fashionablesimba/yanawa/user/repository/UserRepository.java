package our.fashionablesimba.yanawa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(Email email);

}
