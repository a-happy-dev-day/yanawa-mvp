package our.fashionablesimba.yanawa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;
import our.fashionablesimba.yanawa.user.dto.UserDto;
import our.fashionablesimba.yanawa.user.exception.EmailDuplicationException;
import our.fashionablesimba.yanawa.user.exception.LoginFailedException;
import our.fashionablesimba.yanawa.user.exception.UserNotFoundException;
import our.fashionablesimba.yanawa.user.repository.UserRepository;

import javax.security.auth.login.FailedLoginException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    public User findById(long id) {
        final Optional<User> userOptional = userRepository.findById(id);
        userOptional.orElseThrow(() -> new UserNotFoundException());
        return userOptional.get();
    }

    @Transactional(readOnly = true)
    public User findByEmail(final Email email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) return null;

        return user.get();
    }

    @Transactional(readOnly = true)
    public boolean isExistedEmail(Email email) {
        return findByEmail(email) != null;
    }


    public User create(UserDto.SignUpReq dto) {
        if (isExistedEmail(dto.getEmail()))
            throw new EmailDuplicationException(dto.getEmail());

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);

        return userRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public User login(UserDto.SingInReq dto) {
        User user = findByEmail(dto.getEmail());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new LoginFailedException(dto.getEmail());
        }
        return user;
    }

    @Transactional(readOnly = true)
    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(Email.of(email));
    }

    @Transactional(readOnly = true)
    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }


//    public UserDto.Res updateUser(int i, int updateLevel) {
//
//        User byId = findById(i);
//        byId.updateLevel(updateLevel);
//
//        UserDto.Res res = new UserDto.Res(byId);
//        return res;
//
//    }
}
