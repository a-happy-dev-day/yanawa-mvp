package our.fashionablesimba.yanawa.matching.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import our.fashionablesimba.yanawa.matching.domain.NotificationReviewClient;

@Component
public class FakeReviewClient implements NotificationReviewClient {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void noticeMatchingReview(Long matchingId, Long userId) {
        log.debug("{}", "리뷰 알림이 갑니다.");
    }
}
