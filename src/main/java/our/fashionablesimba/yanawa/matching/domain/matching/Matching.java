package our.fashionablesimba.yanawa.matching.domain.matching;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Matching {
    private Long matchingId;
    private Long tennisCourtId;
    private Long userId;
    private LocalDateTime matchingCreationDate;
    private LocalDateTime matchingDate;
    private RatingLevel minimumLevel;
    private RatingLevel maximumLevel;
    private RecruitmentAge recruitmentAge;
    private PreferenceTeamGame preferenceTeamGame;
    private BigDecimal rentalCost;

    private MatchingStatus matchingStatus;

    private String matchingContent;

    protected Matching() {/*no-op*/}

    private Matching(Long matchingId, Long tennisCourtId, Long userId,
                     LocalDateTime matchingCreationDate, LocalDateTime matchingDate,
                     RatingLevel minimumLevel, RatingLevel maximumLevel,
                     RecruitmentAge recruitmentAge, PreferenceTeamGame preferenceTeamGame,
                     BigDecimal rentalCost, MatchingStatus matchingStatus, String matchingContent) {

        if (rentalCost == null || rentalCost.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("코트 비용이 음수가 될 수 없습니다.");
        }

        if (matchingDate.isBefore(matchingCreationDate)) {
            throw new IllegalStateException("과거 날짜로 매칭 일자를 잡을 수 없습니다.");
        }

        if (maximumLevel.compareTo(minimumLevel) < 0) {
            throw new IllegalStateException("최소 레벨이 최대 레벨보다 클 수 없습니다.");
        }

        this.matchingId = matchingId;
        this.tennisCourtId = tennisCourtId;
        this.userId = userId;
        this.matchingCreationDate = matchingCreationDate;
        this.matchingDate = matchingDate;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.recruitmentAge = recruitmentAge;
        this.preferenceTeamGame = preferenceTeamGame;
        this.rentalCost = rentalCost;
        this.matchingStatus = matchingStatus;
        this.matchingContent = matchingContent;
    }

    public Matching(Long tennisCourtId, Long userId, LocalDateTime matchingDate,
                                          RatingLevel minimumLevel, RatingLevel maximumLevel,
                                          RecruitmentAge recruitmentAge, PreferenceTeamGame preferenceTeamGame,
                                          BigDecimal rentalCost, String matchingContent) {
        this(null, tennisCourtId, userId, LocalDateTime.now(),
                matchingDate, minimumLevel, maximumLevel, recruitmentAge,
                preferenceTeamGame, rentalCost, MatchingStatus.RECRUITING, matchingContent);
    }

    public Long getMatchingId() {
        return matchingId;
    }

    public Long getTennisCourtId() {
        return tennisCourtId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getMatchingCreationDate() {
        return matchingCreationDate;
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

    public MatchingStatus getMatchingStatus() {
        return matchingStatus;
    }

    public String getMatchingContent() {
        return matchingContent;
    }
}
