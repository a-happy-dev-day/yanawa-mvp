package our.fashionablesimba.yanawa.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Level {

     @NotEmpty
     int level;

     @NotEmpty
     int year;

     @NotEmpty
     int level_forehand;

     @NotEmpty
     int level_backhand;

     @NotEmpty
     int level_volley;

     @NotEmpty
     int level_serve;


}
