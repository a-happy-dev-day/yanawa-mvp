package our.fashionablesimba.yanawa.matching.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingFixture {
    private static final BigDecimal 만원 = BigDecimal.valueOf(10000L);

    public static final Matching 매칭 =
            new Matching(0L, 0L, LocalDateTime.now().plusDays(1L),
                    RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES,
                    만원, null);

    public static final TennisCourt 여의도_테니스_코트장 = new TennisCourt("여의도 테니스 코트장");

}
