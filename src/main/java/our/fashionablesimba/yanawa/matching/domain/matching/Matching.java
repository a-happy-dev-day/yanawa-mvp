package our.fashionablesimba.yanawa.matching.domain.matching;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Matching {
    @Id
    @GeneratedValue
    private Long matchingId;
    private Long userId;
    private LocalDateTime creationDate;
    private LocalDateTime matchingDate;
    private String tennisCourtName;
    private int numberOfMember;
    @Enumerated
    private RatingLevel minimumLevel;
    @Enumerated
    private RatingLevel maximumLevel;
    @Enumerated
    private RecruitmentAge recruitmentAge;
    @Enumerated
    private PreferenceTeamGame preferenceTeamGame;
    @Enumerated
    private MatchingStatus status;
    private BigDecimal rentalCost;
    private int recruitmentAnnual;
    private String content;

    protected Matching() {/*no-op*/}

    public Matching(Long matchingId, Long userId,
                    LocalDateTime creationDate, LocalDateTime matchingDate,
                    String tennisCourtName, int numberOfMember, RatingLevel minimumLevel, RatingLevel maximumLevel,
                    RecruitmentAge recruitmentAge, PreferenceTeamGame preferenceTeamGame,
                    BigDecimal rentalCost, MatchingStatus status, int recruitmentAnnual, String content) {

        if (rentalCost == null || rentalCost.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("코트 비용이 음수가 될 수 없습니다.");
        }

        if (matchingDate.isBefore(creationDate)) {
            throw new IllegalStateException("과거 날짜로 매칭 일자를 잡을 수 없습니다.");
        }

        if (maximumLevel.compareTo(minimumLevel) < 0) {
            throw new IllegalStateException("최소 레벨이 최대 레벨보다 클 수 없습니다.");
        }

        if (recruitmentAnnual < 0L) {
            throw new IllegalArgumentException("연차는 음수가 될 수 없습니다.");
        }

        if (!(numberOfMember == 2 || numberOfMember == 4)) {
            throw new IllegalArgumentException("모집인원은 두명에서 네명만 가능합니다.");
        }

        if (tennisCourtName.trim().isEmpty()) {
            throw new IllegalArgumentException("코트장 이름이 존재해야 합니다.");
        }


        this.tennisCourtName = tennisCourtName;
        this.matchingId = matchingId;
        this.userId = userId;
        this.numberOfMember = numberOfMember;
        this.creationDate = creationDate;
        this.matchingDate = matchingDate;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.recruitmentAge = recruitmentAge;
        this.preferenceTeamGame = preferenceTeamGame;
        this.rentalCost = rentalCost;
        this.status = status;
        this.content = content;
        this.recruitmentAnnual = recruitmentAnnual;

    }

    public Matching(Long userId, LocalDateTime matchingDate,
                    RatingLevel minimumLevel, RatingLevel maximumLevel,
                    RecruitmentAge recruitmentAge, PreferenceTeamGame preferenceTeamGame,
                    BigDecimal rentalCost, String matchingContent, String tennisCourt, int recruitmentAnnual, int numberOfMember) {
        this(null, userId, LocalDateTime.now(),
                matchingDate, tennisCourt, numberOfMember, minimumLevel, maximumLevel, recruitmentAge,
                preferenceTeamGame, rentalCost, MatchingStatus.RECRUITING, recruitmentAnnual, matchingContent);
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public Long getMatchingId() {
        return matchingId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getMatchingCreationDate() {
        return creationDate;
    }

    public LocalDateTime getMatchingDate() {
        return matchingDate;
    }

    public RatingLevel getMinimumLevel() {
        return minimumLevel;
    }

    public RatingLevel getMaximumLevel() {
        return maximumLevel;
    }

    public RecruitmentAge getRecruitmentAge() {
        return recruitmentAge;
    }

    public PreferenceTeamGame getPreferenceTeamGame() {
        return preferenceTeamGame;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public String getMatchingContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getTennisCourtName() {
        return tennisCourtName;
    }

    public MatchingStatus getStatus() {
        return status;
    }

    public int getRecruitmentAnnual() {
        return recruitmentAnnual;
    }

    public String getContent() {
        return content;
    }

    public void updateStatus(MatchingStatus status) {
        this.status = status;
    }
}
