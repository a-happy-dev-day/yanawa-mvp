package our.fashionablesimba.yanawa.matching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import our.fashionablesimba.yanawa.matching.domain.matching.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static our.fashionablesimba.yanawa.matching.domain.MatchingFixture.매칭;

class MatchingTest {
    private static final BigDecimal 만원 = BigDecimal.valueOf(10000L);
    private static final BigDecimal 음수인가격 = BigDecimal.valueOf(-1000L);

    @Test
    @DisplayName("매칭을 생성한다.")
    void test1() {
        Matching.createMatching(0L, 0L, LocalDateTime.now().plusDays(1L), RatingLevel.A, RatingLevel.B, RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES, 만원, null);
    }

    @Test
    @DisplayName("매칭의 기본 상태는 모집중이다.")
    void test() {
        Assertions.assertThat(매칭.getMatchingStatus()).isEqualTo(MatchingStatus.RECRUITING);
    }

    @Test
    @DisplayName("공간 대여 비용이 음수면 IllegalArgumentException 예외 발생")
    void test2() {
        assertThatThrownBy(() -> Matching.createMatching(0L, 0L, LocalDateTime.now().plusDays(1L), RatingLevel.A, RatingLevel.B, RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES, 음수인가격, null)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("매칭 일자는 현재 이후의 시간이 아니면 예외 발생")
    void test4() {
        assertThatThrownBy(() -> Matching.createMatching(0L, 0L, LocalDateTime.now().minusDays(1L), RatingLevel.A, RatingLevel.B, RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES, 만원, null)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("최소 레벨은 최대 레벨보다 크면 예외 발생")
    void test5() {
        assertThatThrownBy(() -> Matching.createMatching(0L, 0L, LocalDateTime.now(), RatingLevel.B, RatingLevel.A, RecruitmentAge.TWENTIES, PreferenceTeamGame.SINGLES, 만원, null)).isInstanceOf(IllegalStateException.class);
    }

}