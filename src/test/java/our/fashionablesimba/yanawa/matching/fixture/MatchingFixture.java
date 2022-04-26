package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matching.*;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingFixture {
    private static final BigDecimal 만원 = BigDecimal.valueOf(10000L);

    public static final Matching 매칭 =
            new Matching(0L, LocalDateTime.now().plusDays(1L),
                    RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, null, "tennisCourt", 1, 2, PreferenceSex.ALL);

    public static final Matching 매칭_2인 = new Matching(0L, LocalDateTime.now().plusDays(1L),
            RatingLevel.A, RatingLevel.B,
            RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
            만원, null, "tennisCourt", 1, 2, PreferenceSex.ALL);


    public static final Matching 매칭_4인 = new Matching(0L, LocalDateTime.now().plusDays(1L),
            RatingLevel.A, RatingLevel.B,
            RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
            만원, null, "tennisCourt", 1, 4, PreferenceSex.ALL);


    public static final Matching 모집중인_매칭 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.RECRUITING, 1, "", PreferenceSex.ALL);
    public static final Matching 성사된_매칭 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.RECRUITMENT_COMPLETED, 1, "", PreferenceSex.ALL);

    public static final Matching 진행중인_매칭 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.MATCHING_PROGRESS, 1, "", PreferenceSex.ALL);

    public static final Matching 완료된_매칭 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusHours(10L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.MATCHING_COMPLETED, 1, "", PreferenceSex.ALL);

    public static final Matching 끝난지_얼마안된_매칭 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusMinutes(4L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.MATCHING_COMPLETED, 1, "", PreferenceSex.ALL);


    public static final Matching 매칭_후기_완료 =
            new Matching(null, 0L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L),
                    "tennisCourt", 2, RatingLevel.A, RatingLevel.B,
                    RecruitmentAge.TWENTIES, PreferenceTeamGame.MATCH,
                    만원, MatchingStatus.REVIEW_COMPLETED, 1, "", PreferenceSex.ALL);


    public static final UserMatching 사용자매칭 = new UserMatching(1L, 1L);

}
