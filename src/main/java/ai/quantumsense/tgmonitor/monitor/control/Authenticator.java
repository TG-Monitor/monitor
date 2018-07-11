package ai.quantumsense.tgmonitor.monitor.control;

public interface Authenticator {
    void login(String phoneNumber);
    void logout();
    boolean isLoggedIn();
}
