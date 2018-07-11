package ai.quantumsense.tgmonitor.monitor.data;

import java.util.Set;

public interface MonitorData {
    Set<String> getPeers();
    void setPeers(Set<String> peers);
    Set<String> getPatterns();
    void setPatterns(Set<String> patterns);
    Set<String> getEmails();
    void setEmails(Set<String> emails);
}
