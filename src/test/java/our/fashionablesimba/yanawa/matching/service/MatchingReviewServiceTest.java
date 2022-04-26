package our.fashionablesimba.yanawa.matching.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.MatchingRepository;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReview;
import our.fashionablesimba.yanawa.matching.domain.matchingreview.MatchingReviewRepository;
import our.fashionablesimba.yanawa.matching.fixture.MemoryMatchingRepository;
import our.fashionablesimba.yanawa.matching.fixture.MemoryMatchingReviewRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static our.fashionablesimba.yanawa.matching.fixture.MatchingFixture.*;

class MatchingReviewServiceTest {
    private MatchingRepository matchingRepository = new MemoryMatchingRepository();

    private MatchingReviewRepository matchingReviewRepository = new MemoryMatchingReviewRepository();

    MatchingReviewService matchingReviewService = new MatchingReviewService(matchingRepository, matchingReviewRepository);
    @Test
    @DisplayName("후기 작성")
    void test11() {
        Matching matching = matchingRepository.save(완료된_매칭);
        MatchingReview request = new MatchingReview(null, 1L, matching.getMatchingId(), 3L, 4, 5, "");
        assertDoesNotThrow(
                () -> matchingReviewService.review(request)
        );

    }

    @Test
    @DisplayName("10분이 지난 매칭이 아닌 경우 예외 발생")
    void test12() {
        //given
        Matching matching =  matchingRepository.save(끝난지_얼마안된_매칭);
        //when
        MatchingReview request = new MatchingReview(null, 1L, matching.getMatchingId(), 3L, 4, 5, "");
        //then
        assertThatThrownBy(
                () -> matchingReviewService.review(request)
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("매칭이 완료된 상태가 아니면 예외 발생")
    void test13() {
        //given
        Matching matching =  matchingRepository.save(진행중인_매칭);
        //when
        MatchingReview request = new MatchingReview(null, 1L, matching.getMatchingId(), 3L, 4, 5, "");
        //then
        assertThatThrownBy(
                () -> matchingReviewService.review(request)
        ).isInstanceOf(IllegalStateException.class);
    }

}
