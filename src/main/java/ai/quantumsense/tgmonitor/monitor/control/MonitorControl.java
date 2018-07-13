package ai.quantumsense.tgmonitor.monitor.control;

import ai.quantumsense.tgmonitor.monitor.logincode.LoginCodeReader;

public interface MonitorControl {
    void login(String phoneNumber);
    void logout();
    String getPhoneNumber();
}
