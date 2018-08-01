package ai.quantumsense.tgmonitor.monitor;

import ai.quantumsense.tgmonitor.logincodeprompt.LoginCodePrompt;

public interface Monitor {
    void login(String phoneNumber, LoginCodePrompt loginCodePrompt);
    void logout();
    boolean isLoggedIn();
    void start();
    void stop();
    boolean isRunning();
    String getPhoneNumber();
}
