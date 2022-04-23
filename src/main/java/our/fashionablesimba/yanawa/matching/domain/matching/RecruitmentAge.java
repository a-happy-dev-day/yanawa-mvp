package our.fashionablesimba.yanawa.matching.domain.matching;

public enum RecruitmentAge {
    TWENTIES("TWENTIES"),
    THIRTIES("THIRTIES"),
    FORTIES("FORTIES"),
    OVERFIFTIES("OVERFIFTIES");
    private final String ages;

    RecruitmentAge(String ages) {
        this.ages = ages;
    }

    public String getAges() {
        return ages;
    }
}
