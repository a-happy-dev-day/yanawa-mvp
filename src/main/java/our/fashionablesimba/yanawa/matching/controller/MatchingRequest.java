package our.fashionablesimba.yanawa.matching.controller;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.PreferenceTeamGame;
import our.fashionablesimba.yanawa.matching.domain.matching.RatingLevel;
import our.fashionablesimba.yanawa.matching.domain.matching.RecruitmentAge;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingRequest {
    private Long userId;
    private String tennisCourtName;
    private LocalDateTime matchingData;
    private RecruitmentAge age;
    private RatingLevel minimumLevel;
    private RatingLevel maximumLevel;
    private String content;
    private Long recruitmentAnnual;
    private PreferenceTeamGame teamGame;
    private BigDecimal rentalCost;

    protected MatchingRequest() {/*no-op*/}

    public MatchingRequest(Long userId, String tennisCourtName, LocalDateTime matchingData, RecruitmentAge age,
                           RatingLevel minimumLevel, RatingLevel maximumLevel, String content, Long recruitmentAnnual,
                           PreferenceTeamGame teamGame, BigDecimal rentalCost) {
        this.userId = userId;
        this.tennisCourtName = tennisCourtName;
        this.matchingData = matchingData;
        this.age = age;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.content = content;
        this.recruitmentAnnual = recruitmentAnnual;
        this.teamGame = teamGame;
        this.rentalCost = rentalCost;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTennisCourtName() {
        return tennisCourtName;
    }

    public LocalDateTime getMatchingData() {
        return matchingData;
    }

    public RecruitmentAge getAge() {
        return age;
    }

    public RatingLevel getMinimumLevel() {
        return minimumLevel;
    }

    public RatingLevel getMaximumLevel() {
        return maximumLevel;
    }

    public String getContent() {
        return content;
    }

    public Long getRecruitmentAnnual() {
        return recruitmentAnnual;
    }

    public PreferenceTeamGame getTeamGame() {
        return teamGame;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public Matching toMatching() {
        return new Matching(userId, matchingData, minimumLevel, maximumLevel,
                age, teamGame, rentalCost, content, tennisCourtName, recruitmentAnnual);
    }

}
