public class Session {
    private int sessionId;
    private String sessionName;
    private String description;
    private String date;
    private String time;
    private String trainerName;

    public Session(int sessionId, String sessionName, String description, String date, String time, String trainerName) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.trainerName = trainerName;
    }

    // Getters and setters here
}
