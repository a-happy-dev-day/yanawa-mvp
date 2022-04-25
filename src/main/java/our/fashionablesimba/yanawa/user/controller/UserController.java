package our.fashionablesimba.yanawa.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "USER APIs")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation(value = "사용자 회원가입")
    public ResponseEntity<UserDto.Res> signUp(@RequestBody @Valid final UserDto.SignUpReq dto) {
        return ResponseEntity.ok(new UserDto.Res(userService.create(dto)));
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<UserDto.Res> singIn(@RequestBody @Valid final UserDto.SingInReq dto) {
        return ResponseEntity.ok(new UserDto.Res(userService.login(dto)));
    }

    @GetMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    @ApiOperation(value = "사용자 조회")
    public ResponseEntity<UserDto.Res> getUser(@PathVariable final Long userId) {
        return ResponseEntity.ok(new UserDto.Res(userService.findById(userId)));
    }

}
