package our.fashionablesimba.yanawa.matching.domain.matching;

public enum PreferenceTeamGame {
    SINGLES("SINGLES"),
    DOUBLES("DOUBLES"),
    RELLY("RELLY");
    private final String teamGame;

    PreferenceTeamGame(String teamGame) {
        this.teamGame = teamGame;
    }

    public String getTeamGame() {
        return teamGame;
    }
}
