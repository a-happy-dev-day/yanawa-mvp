package our.fashionablesimba.yanawa.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import our.fashionablesimba.yanawa.user.domain.User;
import our.fashionablesimba.yanawa.user.dto.UserDto;
import our.fashionablesimba.yanawa.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<UserDto.Res> signUp(@RequestBody @Valid final UserDto.SignUpReq dto) {
        return ResponseEntity.ok(new UserDto.Res(userService.create(dto)));
    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<UserDto.Res> singIn(@RequestBody @Valid final UserDto.SingInReq dto) {
        return ResponseEntity.ok(new UserDto.Res(userService.login(dto)));
    }

    @GetMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<UserDto.Res> getUser(@PathVariable final Long userId) {
        return ResponseEntity.ok(new UserDto.Res(userService.findById(userId)));
    }

    /**
     * 매칭 리뷰 controller에서 처리
     */
//    @PutMapping("/{updateLevel}")
//    public ResponseEntity<UserDto.Res> getUser(@PathVariable final int updateLevel) {
//
//        UserDto.Res res = userService.updateUser(1, updateLevel);
//        return ResponseEntity.ok(res);
//
//    }


}
