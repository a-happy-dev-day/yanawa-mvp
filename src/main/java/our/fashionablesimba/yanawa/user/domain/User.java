package our.fashionablesimba.yanawa.user.domain;

import lombok.*;
import our.fashionablesimba.yanawa.user.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

    private String password;

    private String nickname;

    private String sex;

    private LocalDate birth;

//    @Embedded
//    private Level level;

    private int level;

    @Builder
    public User(Email email, String password, String nickname, String sex, LocalDate birth, int level) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.birth = birth;
        this.level = level;
    }

    public void updateLevel(int level) {
        this.level = (this.level + level) / 2;
    }

}
