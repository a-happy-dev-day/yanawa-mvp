package our.fashionablesimba.yanawa.matching.fixture;

import our.fashionablesimba.yanawa.matching.domain.matchingreview.NotificationReviewClient;

public class FakeNotificationReviewClient implements NotificationReviewClient {
    @Override
    public void noticeMatchingReview(Long matchingId, Long userId) {
        System.out.println(" 후기를 작성하라고 알립니다.");
    }
}
