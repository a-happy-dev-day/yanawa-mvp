package our.fashionablesimba.yanawa.matching.domain.matching;

public enum PreferenceSex {
    MEN("MEN"),
    WOMEN("WOMEN"),
    ALL("ALL");

    private final String preference;

    PreferenceSex(String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return preference;
    }
}
