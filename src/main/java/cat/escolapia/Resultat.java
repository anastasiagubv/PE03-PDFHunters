package cat.escolapia;

public class Resultat {

    private final String missionName;
    private final String foundPassword; // null si no s'ha trobat
    private final long attempts;
    private final double timeSeconds;

    public Resultat(String missionName, String foundPassword, long attempts, double timeSeconds) {
        this.missionName = missionName;
        this.foundPassword = foundPassword;
        this.attempts = attempts;
        this.timeSeconds = timeSeconds;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getFoundPassword() {
        return foundPassword;
    }

    public long getAttempts() {
        return attempts;
    }

    public double getTimeSeconds() {
        return timeSeconds;
    }

    public boolean isFound() {
        return foundPassword != null;
    }

    public double getSpeed() {
        if (timeSeconds <= 0) {
            return 0;
        }
        return attempts / timeSeconds;
    }
}
