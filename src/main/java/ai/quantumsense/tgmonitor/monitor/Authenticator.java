package ai.quantumsense.tgmonitor.monitor;

public interface Authenticator {
    void login(String phoneNumber);
    void logout();
    boolean isLoggedIn();
}
