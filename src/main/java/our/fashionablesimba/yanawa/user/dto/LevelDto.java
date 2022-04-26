package our.fashionablesimba.yanawa.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LevelDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {

        int year;
        int level_forehand;
        int level_backhand;
        int level_volley;
        int level_serve;

    }


}
