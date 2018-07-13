package ai.quantumsense.tgmonitor.monitor;

public interface Monitor {
    void login(String phoneNumber);
    void logout();
    String getPhoneNumber();
}
