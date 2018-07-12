package ai.quantumsense.tgmonitor.monitor.control;

import ai.quantumsense.tgmonitor.monitor.logincode.LoginCodeReader;

public interface MonitorControl {
    MonitorState getState();
    void login(String phoneNumber);
    void logout();
    void start();
    void pause();
    String getPhoneNumber();
    LoginCodeReader getLoginCodeReader();
}
