package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance;
    private String backupDir = "backups";
    private AppConfig() {}
    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
    public String getBackupDir() { return backupDir; }
    public void setBackupDir(String backupDir) { this.backupDir = backupDir; }
}
