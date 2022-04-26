package our.fashionablesimba.yanawa.matching.exception;

public class NotFoundMatchingReviewException extends RuntimeException {

    private static final String message = "리뷰가 존재하지 않습니다.";
    public NotFoundMatchingReviewException() {
        super(message);
    }
}
