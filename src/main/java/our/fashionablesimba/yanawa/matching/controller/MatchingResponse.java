package our.fashionablesimba.yanawa.matching.controller;

import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.PreferenceTeamGame;
import our.fashionablesimba.yanawa.matching.domain.matching.RatingLevel;
import our.fashionablesimba.yanawa.matching.domain.matching.RecruitmentAge;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingResponse {

    private final Long userId;
    private final String tennisCourtName;
    private final LocalDateTime matchingData;
    private final RecruitmentAge age;
    private final RatingLevel minimumLevel;
    private final RatingLevel maximumLevel;
    private final String content;
    private final Long recruitmentAnnual;
    private final PreferenceTeamGame teamGame;
    private final BigDecimal rentalCost;

    public MatchingResponse(Long userId, String tennisCourtName, LocalDateTime matchingData, RecruitmentAge age, RatingLevel minimumLevel, RatingLevel maximumLevel, String content, Long recruitmentAnnual, PreferenceTeamGame teamGame, BigDecimal rentalCost) {
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

    public MatchingResponse(Matching matching) {
        this(matching.getUserId(), matching.getTennisCourt(), matching.getMatchingDate(),
                matching.getRecruitmentAge(), matching.getMinimumLevel(), matching.getMaximumLevel(),
                matching.getMatchingContent(), matching.getRecruitmentAnnual(), matching.getPreferenceTeamGame(),
                matching.getRentalCost());
    }
}
