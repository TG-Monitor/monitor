package ai.quantumsense.tgmonitor.monitor;

import java.util.Set;

public interface Monitor {
    MonitorState getState();
    void login(String phoneNumber);
    void logout();
    void start();
    void pause();
    String getPhoneNumber();
    Set<String> getPeers();
    void setPeers(Set<String> peers);
    Set<String> getPatterns();
    void setPatterns(Set<String> patterns);
    Set<String> getEmails();
    void setEmails(Set<String> emails);
}
