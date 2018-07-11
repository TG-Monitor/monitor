package ai.quantumsense.tgmonitor.monitor.data;

import java.util.LinkedHashSet;
import java.util.Set;

public class MonitorDataImpl implements MonitorData {

    private Set<String> peers = new LinkedHashSet<>();
    private Set<String> patterns = new LinkedHashSet<>();
    private Set<String> emails = new LinkedHashSet<>();

    private static MonitorData instance = null;

    public MonitorDataImpl() {
        instance = this;
    }

    static MonitorData get() {
        return instance;
    }

    @Override
    public Set<String> getPeers() {
        return new LinkedHashSet<>(peers);
    }

    @Override
    public void setPeers(Set<String> peers) {
        this.peers = new LinkedHashSet<>(peers);
    }

    @Override
    public Set<String> getPatterns() {
        return new LinkedHashSet<>(patterns);
    }

    @Override
    public void setPatterns(Set<String> patterns) {
        this.patterns = new LinkedHashSet<>(patterns);
    }

    @Override
    public Set<String> getEmails() {
        return new LinkedHashSet<>(emails);
    }

    @Override
    public void setEmails(Set<String> emails) {
        this.emails = new LinkedHashSet<>(emails);
    }
}
