public class SharedFilePath {
    private static SharedFilePath instance = null;
    private String filePath;

    private SharedFilePath() {
    }

    public static SharedFilePath getInstance() {
        if (instance == null) {
            instance = new SharedFilePath();
        }
        return instance;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}