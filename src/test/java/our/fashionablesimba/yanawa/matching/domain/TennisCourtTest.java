package our.fashionablesimba.yanawa.matching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import our.fashionablesimba.yanawa.matching.domain.tenniscourt.TennisCourt;
import our.fashionablesimba.yanawa.matching.domain.tenniscourt.TennisCourtStatus;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TennisCourtTest {

    @Test
    @DisplayName("테니스 코트장을 생성할 수 있다.")
    void test1() {
        assertDoesNotThrow(
                () -> new TennisCourt("여의도 테니스 코트장")
        );
    }

    @Test
    @DisplayName("생성된 테니스 코트장의 이름이 2글자 이하면 IllegalArgumentException 발생")
    void test3() {
        assertThatThrownBy(
                () -> new TennisCourt("1")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성된 테니스 코트장은 비어있다.")
    void test2() {
        TennisCourt court = new TennisCourt("여의도 테니스 코트장");
        assertThat(court.getTennisCourtStatus()).isEqualTo(TennisCourtStatus.EMPTY);
    }

}