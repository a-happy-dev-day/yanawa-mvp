package our.fashionablesimba.yanawa.matching.domain.tenniscourt;

public class TennisCourt {

    private Long tennisCourtId;
    private String tennisCourtName;
    private TennisCourtStatus tennisCourtStatus;

    protected TennisCourt() {/*no-op*/}

    private TennisCourt(Long tennisCourtId, String tennisCourtName, TennisCourtStatus tennisCourtStatus) {

        if (tennisCourtName == null || tennisCourtName.trim().isEmpty()) {
            throw new IllegalArgumentException("테니스 코트장 이름이 존재해야 합니다.");
        }

        if (tennisCourtName.trim().length() < 3) {
            throw new IllegalArgumentException("테니스 코트장의 이름은 3글자 이사잉어야 합니다.");
        }

        this.tennisCourtId = tennisCourtId;
        this.tennisCourtName = tennisCourtName;
        this.tennisCourtStatus = tennisCourtStatus;
    }

    public static TennisCourt createTennisCourt(String tennisCourtName) {
        return new TennisCourt(null, tennisCourtName, TennisCourtStatus.EMPTY);
    }


    public Long getTennisCourtId() {
        return tennisCourtId;
    }

    public String getTennisCourtName() {
        return tennisCourtName;
    }

    public TennisCourtStatus getTennisCourtStatus() {
        return tennisCourtStatus;
    }
}
