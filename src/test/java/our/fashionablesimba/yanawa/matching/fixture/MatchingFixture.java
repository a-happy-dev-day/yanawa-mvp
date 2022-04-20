package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.PreferenceTeamGame;
import our.fashionablesimba.yanawa.matching.domain.matching.RatingLevel;
import our.fashionablesimba.yanawa.matching.domain.matching.RecruitmentAge;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingFixture {
    private static final BigDecimal 만원 = BigDecimal.valueOf(10000L);

    public static final Matching 매칭 =
            new Matching( 0L, LocalDateTime.now().plusDays(1L),
                    RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES,
                    만원, null, "tennisCourt", 1L);

    public static final UserMatching 사용자매칭 = new UserMatching( 1L, 1L);
}
