package our.fashionablesimba.yanawa.matching.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingStatus;

import static org.assertj.core.api.Assertions.*;

class UserMatchingTest {

    @Test
    @DisplayName("사용자 매칭을 생성할 수 있다.")
    void test1() {
        Assertions.assertDoesNotThrow(
                () -> new UserMatching(1L, 1L, 1L)
        );
    }

    @Test
    @DisplayName("사용자 매칭이 생성되면 상태가 수락이 된다.")
    void test2() {
        UserMatching userMatching = new UserMatching(1L, 1L, 1L);
        assertThat(userMatching.getUserMatchingStatus()).isEqualTo(UserMatchingStatus.ACCEPTED);
    }
}