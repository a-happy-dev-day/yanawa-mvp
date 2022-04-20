package our.fashionablesimba.yanawa.user.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {


        @Valid
        private Email email;

        @NotEmpty(message="PASSWORD_IS_MANDATORY")
        private String password;

        @NotEmpty
        @Size(max = 4, message = "닉네임은 최대 4자까지만 가능합니다.")
        private String nickname;

        @NotEmpty
        @Size(min = 2, max = 2, message = "성별은 남자,여자만 가능합니다.")
        private String sex;

        private LocalDate birth;

        @Builder
        public SignUpReq(Email email, String nickname, String password, String sex, LocalDate birth) {
            this.email = email;
            this.password = password;
            this.nickname = nickname;
            this.sex = sex;
            this.birth = birth;
        }

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .password(this.password)
                    .nickname(this.nickname)
                    .sex(this.sex)
                    .birth(this.birth)
                    .build();
        }

    }
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Res {

        private Email email;

        private String nickname;

        private String sex;

        private LocalDate birth;

        public Res(User user) {
            this.email = user.getEmail();
            this.nickname = user.getNickname();
            this.sex = user.getSex();
            this.birth = user.getBirth();
        }

    }




}
