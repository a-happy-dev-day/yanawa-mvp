package our.fashionablesimba.yanawa.matching.domain.matching;

public enum MatchingStatus {
    RECRUITING("RECRUITING"),
    RECRUITMENT_COMPLETED("RECRUITMENT_COMPLETED"),
    MATCHING_PROGRESS("MATCHING_PROGRESS"),
    MATCHING_COMPLETED("MATCHING_COMPLETED"),
    REVIEW_COMPLETED("REVIEW_COMPLETED");
    private final String status;

    MatchingStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
