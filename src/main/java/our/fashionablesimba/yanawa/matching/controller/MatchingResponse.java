package our.fashionablesimba.yanawa.matching.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.matching.PreferenceTeamGame;
import our.fashionablesimba.yanawa.matching.domain.matching.RatingLevel;
import our.fashionablesimba.yanawa.matching.domain.matching.RecruitmentAge;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MatchingResponse {

    private final  Long userId;
    private final String tennisCourtName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "Asia/Seoul")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime matchingData;
    private final RecruitmentAge age;
    private final RatingLevel minimumLevel;
    private final RatingLevel maximumLevel;
    private final String content;
    private int numberOfMember;
    private final int recruitmentAnnual;
    private final PreferenceTeamGame teamGame;
    private final BigDecimal rentalCost;

    public MatchingResponse(Long userId, String tennisCourtName, LocalDateTime matchingData, RecruitmentAge age, RatingLevel minimumLevel, RatingLevel maximumLevel, String content, int numberOfMember, int recruitmentAnnual, PreferenceTeamGame teamGame, BigDecimal rentalCost) {
        this.userId = userId;
        this.tennisCourtName = tennisCourtName;
        this.matchingData = matchingData;
        this.age = age;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.content = content;
        this.numberOfMember = numberOfMember;
        this.recruitmentAnnual = recruitmentAnnual;
        this.teamGame = teamGame;
        this.rentalCost = rentalCost;
    }

    public MatchingResponse(Matching matching) {
        this(matching.getUserId(), matching.getTennisCourtName(), matching.getMatchingDate(),
                matching.getRecruitmentAge(), matching.getMinimumLevel(), matching.getMaximumLevel(),
                matching.getMatchingContent(), matching.getNumberOfMember(), matching.getRecruitmentAnnual(), matching.getPreferenceTeamGame(),
                matching.getRentalCost());
    }

    @Override
    public String toString() {
        return "MatchingResponse{" +
                "userId=" + userId +
                ", tennisCourtName='" + tennisCourtName + '\'' +
                ", matchingData=" + matchingData +
                ", age=" + age +
                ", minimumLevel=" + minimumLevel +
                ", maximumLevel=" + maximumLevel +
                ", content='" + content + '\'' +
                ", numberOfMember=" + numberOfMember +
                ", recruitmentAnnual=" + recruitmentAnnual +
                ", teamGame=" + teamGame +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
