package our.fashionablesimba.yanawa.matching.domain;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.PreferenceTeamGame;
import our.fashionablesimba.yanawa.matching.domain.matching.RatingLevel;
import our.fashionablesimba.yanawa.matching.domain.matching.RecruitmentAge;
import our.fashionablesimba.yanawa.matching.domain.tenniscourt.TennisCourt;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingFixture {
    private static final BigDecimal 만원 = BigDecimal.valueOf(10000L);

    public static final Matching 매칭 =
            Matching.createMatching(0L, 0L, LocalDateTime.now().plusDays(1L),
                    RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES,
                    만원, null);

    public static final TennisCourt 여의도_테니스_코트장 = TennisCourt.createTennisCourt("여의도 테니스 코트장");

    public static final UserMatching 사용자매칭 = UserMatching.createMatchingAndAccepted(1L, 1L, 1L);
}
