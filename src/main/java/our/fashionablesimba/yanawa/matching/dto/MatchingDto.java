package our.fashionablesimba.yanawa.matching.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import our.fashionablesimba.yanawa.matching.domain.matching.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "매칭 상세 정보", description = "매칭을 생성하고 조회하는 클래스")
public class MatchingDto {

    @ApiModelProperty(value = "매칭 PK")
    private Long matchingId;
    @ApiModelProperty(value = "생성하려는 사용자 PK")
    private Long userId;
    @ApiModelProperty(value = "코트장 이름, 코트장 이름은 null 이 될 수 없음")
    private String tennisCourtName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "Asia/Seoul")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty(value = "매칭 일자, 현재 매칭 일자를 중복해서 생성할 수 없고, 현재보다 과거의 매칭을 잡을 수 없음(형식은 yyyy-ddTHH:mm ex)2015-12T12:23)")
    private LocalDateTime matchingDate;
    @ApiModelProperty(value = "모집하는 인원의 수, 2명 또는 4명만을 모집 가능")
    private int numberOfMember;
    @ApiModelProperty(value = "모집하려는 연령대")
    private RecruitmentAge age;
    @ApiModelProperty(value = "최소 요구 레벨")
    private RatingLevel minimumLevel;
    @ApiModelProperty(value = "최대 요구 레벨")
    private RatingLevel maximumLevel;
    @ApiModelProperty(value = "본문 영역")
    private String content;
    @ApiModelProperty(value = "모집하려는 상대방의 연차 요건")
    private int recruitmentAnnual;
    @ApiModelProperty(value = "선호하는 팀게임의 종류")
    private PreferenceTeamGame teamGame;
    @ApiModelProperty(value = "1인당 내야할 코트 비용, 음수가 될수 없음")
    private BigDecimal rentalCost;
    @ApiModelProperty(value = "모집하려는 성별")
    private PreferenceSex sex;

    public MatchingDto() {/*no-op*/}

    public MatchingDto(Long matchingId, Long userId, String tennisCourtName, LocalDateTime matchingDate, int numberOfMember, RecruitmentAge age, RatingLevel minimumLevel, RatingLevel maximumLevel, String content, int recruitmentAnnual, PreferenceTeamGame teamGame, BigDecimal rentalCost, PreferenceSex sex) {
        this.matchingId = matchingId;
        this.userId = userId;
        this.tennisCourtName = tennisCourtName;
        this.matchingDate = matchingDate;
        this.numberOfMember = numberOfMember;
        this.age = age;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.content = content;
        this.recruitmentAnnual = recruitmentAnnual;
        this.teamGame = teamGame;
        this.rentalCost = rentalCost;
        this.sex = sex;
    }

    public Long getMatchingId() {
        return matchingId;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTennisCourtName() {
        return tennisCourtName;
    }

    public LocalDateTime getMatchingDate() {
        return matchingDate;
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

    public int getRecruitmentAnnual() {
        return recruitmentAnnual;
    }

    public PreferenceTeamGame getTeamGame() {
        return teamGame;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public PreferenceSex getSex() {
        return sex;
    }

    public Matching toMatching() {
        return new Matching(userId, matchingDate, minimumLevel, maximumLevel,
                age, teamGame, rentalCost, content, tennisCourtName, recruitmentAnnual, numberOfMember, sex);
    }

    public MatchingDto(Matching matching) {
        this(matching.getMatchingId(), matching.getUserId(), matching.getTennisCourtName(), matching.getMatchingDate(), matching.getNumberOfMember(),
                matching.getRecruitmentAge(), matching.getMinimumLevel(), matching.getMaximumLevel(),
                matching.getMatchingContent(), matching.getRecruitmentAnnual(), matching.getPreferenceTeamGame(),
                matching.getRentalCost(), matching.getSex());
    }


}
