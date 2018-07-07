package ai.quantumsense.tgmonitor.monitor;

import java.util.*;

import static ai.quantumsense.tgmonitor.monitor.MonitorState.*;

public class Monitor {

    private String phoneNumber = null;
    private int interval = 300;
    private Set<String> peers = new LinkedHashSet<>();
    private Set<String> patterns = new LinkedHashSet<>();
    private Set<String> emails = new LinkedHashSet<>();
    private MonitorState state = LOGGED_OUT;

    private Authenticator authenticator;
    private Executor executor;

    public Monitor(Authenticator authenticator, Executor executor) {
        this.authenticator = authenticator;
        this.executor = executor;
    }

    public MonitorState getState() {
        return state;
    }

    public void login(String phoneNumber) {
        switch (state) {
            case LOGGED_IN_RUNNING:
            case LOGGED_IN_PAUSED:
                illegalState("Attempting to log in, but already logged in");
                break;
            case LOGGED_OUT:
                authenticator.login(phoneNumber);
                this.phoneNumber = phoneNumber;
                state = LOGGED_IN_PAUSED;
                break;
        }
    }

    public void logout() {
        switch (state) {
            case LOGGED_IN_RUNNING:
                pause();
            case LOGGED_IN_PAUSED:
                authenticator.logout();
                phoneNumber = null;
                state = LOGGED_OUT;
                break;
            case LOGGED_OUT:
                illegalState("Attempting to log out, but already logged out");
                break;
        }
    }

    public void start() {
        switch (state) {
            case LOGGED_IN_RUNNING:
                illegalState("Attempting to start monitor, but is already running");
                break;
            case LOGGED_IN_PAUSED:
                executor.startAll();
                state = LOGGED_IN_RUNNING;
                break;
            case LOGGED_OUT:
                illegalState("Attempting to start monitor, but is not logged in");
                break;
        }
    }

    public void pause() {
        switch (state) {
            case LOGGED_IN_RUNNING:
                executor.stopAll();
                state = LOGGED_IN_PAUSED;
                break;
            case LOGGED_IN_PAUSED:
                illegalState("Attempting to pause monitor, but is already paused");
                break;
            case LOGGED_OUT:
                illegalState("Attempting to pause monitor, but is not logged in");
                break;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getInterval() {
        return interval;
    }

//    public void setInterval(int interval) {
//        this.interval = interval;
//    }

    public Set<String> getPeers() {
        return new LinkedHashSet<>(peers);
    }

    public void setPeers(Set<String> peers) {
        this.peers = new LinkedHashSet<>(peers);
    }

    public Set<String> getPatterns() {
        return new LinkedHashSet<>(patterns);
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = new LinkedHashSet<>(patterns);
    }

    public Set<String> getEmails() {
        return new LinkedHashSet<>(emails);
    }

    public void setEmails(Set<String> emails) {
        this.emails = new LinkedHashSet<>(emails);
    }

    private void illegalState(String msg) {
        throw new IllegalStateException(msg);
    }
}
