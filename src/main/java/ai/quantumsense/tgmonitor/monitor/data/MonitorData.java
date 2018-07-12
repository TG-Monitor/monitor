package ai.quantumsense.tgmonitor.monitor.data;

import java.util.Set;

public interface MonitorData {
    Set<String> getPeers();
    void setPeers(Set<String> peers);
    void addPeer(String peer);
    void addPeers(Set<String> peers);
    void removePeer(String peer);
    void removePeers(Set<String> peers);

    Set<String> getPatterns();
    void setPatterns(Set<String> patterns);
    void addPattern(String pattern);
    void addPatterns(Set<String> patterns);
    void removePattern(String pattern);
    void removePatterns(Set<String> patterns);

    Set<String> getEmails();
    void setEmails(Set<String> emails);
    void addEmail(String email);
    void addEmails(Set<String> emails);
    void removeEmail(String email);
    void removeEmails(Set<String> emails);
}
