package ai.quantumsense.tgmonitor.monitor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Monitor {

    private String phoneNumber = null;
    private int interval = 300;
    private Set<String> peers = new LinkedHashSet<>();
    private Set<String> patterns = new LinkedHashSet<>();
    private Set<String> emails = new LinkedHashSet<>();
    private MonitorState state = MonitorState.PHONE_UNSET;

    private MonitorState getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public List<String> getPeers() {
        return new ArrayList<>(peers);
    }

    public void setPeers(List<String> peers) {
        this.peers = new LinkedHashSet<>(peers);
    }

    public List<String> getPatterns() {
        return new ArrayList<>(patterns);
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = new LinkedHashSet<>(patterns);
    }

    public List<String> getEmails() {
        return new ArrayList<>(emails);
    }

    public void setEmails(List<String> emails) {
        this.emails = new LinkedHashSet<>(emails);
    }
}
