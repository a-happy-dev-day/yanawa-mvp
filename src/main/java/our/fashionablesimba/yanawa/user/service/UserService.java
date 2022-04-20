package our.fashionablesimba.yanawa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;
import our.fashionablesimba.yanawa.user.dto.UserDto;
import our.fashionablesimba.yanawa.user.exception.EmailDuplicationException;
import our.fashionablesimba.yanawa.user.exception.UserNotFoundException;
import our.fashionablesimba.yanawa.user.repository.UserRepository;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findById(long id) {
        final Optional<User> userOptional = userRepository.findById(id);
        userOptional.orElseThrow(() -> new UserNotFoundException(id));
        return userOptional.get();
    }

    @Transactional(readOnly = true)
    public User findByEmail(final Email email) {
        final User user = userRepository.findByEmail(email);
//        if (user == null) throw new UserNotFoundException();
        return user;
    }

    @Transactional(readOnly = true)
    public boolean isExistedEmail(Email email) {
        return findByEmail(email) != null;
    }


    public User create(UserDto.SignUpReq dto) {
        if (isExistedEmail(dto.getEmail()))
            throw new EmailDuplicationException(dto.getEmail());
        return userRepository.save(dto.toEntity());
    }

}
