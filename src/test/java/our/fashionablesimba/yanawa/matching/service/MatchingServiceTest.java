package our.fashionablesimba.yanawa.matching.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import our.fashionablesimba.yanawa.matching.domain.NotificationReviewClient;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatchingRepository;
import our.fashionablesimba.yanawa.matching.fixture.FakeNotificationReviewClient;
import our.fashionablesimba.yanawa.matching.fixture.MemoryMatchingRepository;
import our.fashionablesimba.yanawa.matching.fixture.MemoryUserMatchingRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static our.fashionablesimba.yanawa.matching.fixture.MatchingFixture.*;

class MatchingServiceTest {

    private MatchingRepository matchingRepository = new MemoryMatchingRepository();
    private UserMatchingRepository userMatchingRepository = new MemoryUserMatchingRepository();
    private NotificationReviewClient notificationReviewClient = new FakeNotificationReviewClient();

    MatchingService matchingService = new MatchingService(matchingRepository, userMatchingRepository, notificationReviewClient);

    @Test
    @DisplayName("매칭 등록")
    void test1() {
        Matching matching = 매칭;
        assertDoesNotThrow(
                () -> matchingService.recruit(matching)
        );
    }

    @Test
    @DisplayName("매칭을 등록하는 사용자가 해당 시간에 매칭이 존재하면 IllegalStateException 예외 발생")
    void test2() {
        matchingRepository.save(매칭);
        assertThatThrownBy(
                () -> matchingService.recruit(매칭)
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("매칭 요청")
    void test3() {
        Matching request = matchingRepository.save(매칭);
        assertAll(
                () -> assertDoesNotThrow(() -> matchingService.apply(1L, request.getMatchingId())),
                () -> assertThat(userMatchingRepository.findAllByMatchingId(request.getMatchingId()).size()).isGreaterThan(0)
        );
    }

    @Test
    @DisplayName("매칭을 요청할 때, 신청한 사람이 모집인원과 같지 않으면 IllegalStateException 예외 발생")
    void test4() {
        Matching matching = matchingRepository.save(매칭_2인);
        matchingService.apply(2L, matching.getMatchingId());

        assertThatThrownBy(
                () -> matchingService.apply(3L, matching.getMatchingId())
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("매칭을 요청할 때, 매칭이 모집 중이 아니라면 IllegalStateException 예외 발생")
    void test5() {
        Matching request = matchingRepository.save(성사된_매칭);
        assertThatThrownBy(
                () -> matchingService.apply(1L, request.getMatchingId())
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @ValueSource
    @DisplayName("모집 완료할 때, 현재 매칭이 모집 중이 아니면 IllegalStateException 예외 발생")
    void test6() {
        assertAll(
                () -> {
                    Matching matching = matchingRepository.save(성사된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(진행중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(매칭_후기_완료);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(완료된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                }
        );
    }

    @Test
    @DisplayName("매칭을 진행할 때, 모집이 완료되지 않았다면  IllegalStateException 예외 발생")
    void test7() {
        assertAll(
                () -> {
                    Matching matching = matchingRepository.save(모집중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.proceedMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(진행중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.proceedMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(완료된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(매칭_후기_완료);
                    assertThatThrownBy(
                            () -> matchingService.proceedMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                }
        );
    }

    @Test
    @DisplayName("매칭을 끝낼 때, 매칭이 진행중이 아니었으면 IllegalStateException 예외 발생")
    void test8() {
        assertAll(
                () -> {
                    Matching matching = matchingRepository.save(모집중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(성사된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(완료된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeRecruitment(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(매칭_후기_완료);
                    assertThatThrownBy(
                            () -> matchingService.completeMatch(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                }
        );
    }

    @Test
    @DisplayName("매칭 후기가 작성된 상태로 변경할 때, 매칭이 완료되지 안했으면 IllegalStateException 예외 발생")
    void test9() {
        assertAll(
                () -> {
                    Matching matching = matchingRepository.save(모집중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeReview(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(성사된_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeReview(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(진행중인_매칭);
                    assertThatThrownBy(
                            () -> matchingService.completeReview(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                },
                () -> {
                    Matching matching = matchingRepository.save(매칭_후기_완료);
                    assertThatThrownBy(
                            () -> matchingService.completeReview(matching.getMatchingId())
                    ).isInstanceOf(IllegalStateException.class);
                }
        );
    }
}
