package our.fashionablesimba.yanawa.user.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
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

    @Builder
    public User(Email email, String password, String nickname, String sex, LocalDate birth) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.birth = birth;
    }



}
