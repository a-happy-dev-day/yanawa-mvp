package our.fashionablesimba.yanawa.matching.domain.matching;

public enum PreferenceTeamGame {
    MATCH("MATCH"),
    RELLY("RELLY");
    private final String teamGame;

    PreferenceTeamGame(String teamGame) {
        this.teamGame = teamGame;
    }

    public String getTeamGame() {
        return teamGame;
    }
}
