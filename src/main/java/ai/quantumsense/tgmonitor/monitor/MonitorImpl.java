package ai.quantumsense.tgmonitor.monitor;

import java.util.LinkedHashSet;
import java.util.Set;

import static ai.quantumsense.tgmonitor.monitor.MonitorState.*;

public class MonitorImpl implements Monitor {

    private String phoneNumber = null;
    private Set<String> peers = new LinkedHashSet<>();
    private Set<String> patterns = new LinkedHashSet<>();
    private Set<String> emails = new LinkedHashSet<>();
    private MonitorState state = LOGGED_OUT;

    private Authenticator authenticator;
    private Executor executor;

    public MonitorImpl(Authenticator authenticator, Executor executor) {
        this.authenticator = authenticator;
        this.executor = executor;
    }

    @Override
    public MonitorState getState() {
        return state;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
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

    private void illegalState(String msg) {
        throw new IllegalStateException(msg);
    }
}
