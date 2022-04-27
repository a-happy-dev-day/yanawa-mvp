package our.fashionablesimba.yanawa.user.dto;


import lombok.*;
import our.fashionablesimba.yanawa.user.domain.Email;
import our.fashionablesimba.yanawa.user.domain.User;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDto {

    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {

        @Valid
        private Email email;

        @NotEmpty(message="비밀번호는 필수입니다.")
        private String password;

        @NotEmpty
        @Size(max = 4, message = "닉네임은 최대 4자까지만 가능합니다.")
        private String nickname;

        @NotEmpty
        @Size(min = 2, max = 2, message = "성별은 남자,여자만 가능합니다.")
        private String sex;

        private LocalDate birth;

        private Integer year;

        private Integer level;

        @Builder
        public SignUpReq(Email email, String nickname, String password, String sex, LocalDate birth, int level) {
            this.email = email;
            this.password = password;
            this.nickname = nickname;
            this.sex = sex;
            this.birth = birth;
            this.level = level;
        }

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .password(this.password)
                    .nickname(this.nickname)
                    .sex(this.sex)
                    .birth(this.birth)
                    .year(this.year)
                    .level(this.level)
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

        private Integer year;

        private Integer level;

        public Res(User user) {
            this.email = user.getEmail();
            this.nickname = user.getNickname();
            this.sex = user.getSex();
            this.year = user.getYear();
            this.birth = user.getBirth();
            this.level = user.getLevel();
        }

    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SingInReq {

        @Valid
        private Email email;
        @NotEmpty(message="비밀번호는 필수입니다.")
        private String password;

    }
}
