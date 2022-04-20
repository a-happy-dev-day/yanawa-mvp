package our.fashionablesimba.yanawa.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public UserDto.Res signUp(@RequestBody @Valid final UserDto.SignUpReq dto) {
        return new UserDto.Res(userService.create(dto));
    }

}
