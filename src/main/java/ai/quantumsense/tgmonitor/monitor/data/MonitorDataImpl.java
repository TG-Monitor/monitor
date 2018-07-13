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
    public void addPeer(String peer) {
        this.peers.add(peer);
    }

    @Override
    public void addPeers(Set<String> peers) {
        this.peers.addAll(peers);
    }

    @Override
    public void removePeer(String peer) {
        this.peers.remove(peer);
    }

    @Override
    public void removePeers(Set<String> peers) {
        this.peers.removeAll(peers);
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
    public void addPattern(String pattern) {
        this.patterns.add(pattern);
    }

    @Override
    public void addPatterns(Set<String> patterns) {
        this.patterns.addAll(patterns);
    }

    @Override
    public void removePattern(String pattern) {
        this.patterns.remove(pattern);
    }

    @Override
    public void removePatterns(Set<String> patterns) {
        this.patterns.removeAll(patterns);
    }

    @Override
    public Set<String> getEmails() {
        return new LinkedHashSet<>(emails);
    }

    @Override
    public void setEmails(Set<String> emails) {
        this.emails = new LinkedHashSet<>(emails);
    }

    @Override
    public void addEmail(String email) {
        this.emails.add(email);
    }

    @Override
    public void addEmails(Set<String> emails) {
        this.emails.addAll(emails);
    }

    @Override
    public void removeEmail(String email) {
        this.emails.remove(email);
    }

    @Override
    public void removeEmails(Set<String> emails) {
        this.emails.removeAll(emails);
    }
}
