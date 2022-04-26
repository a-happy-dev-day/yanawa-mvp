package our.fashionablesimba.yanawa.matching.domain.matching;

public enum RatingLevel {
    A("GRADE-A"),
    B("GRADE-B"),
    C("GRADE-C"),
    D("GRADE-D"),
    E("GRADE-E");
    private String grade;

    RatingLevel(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
