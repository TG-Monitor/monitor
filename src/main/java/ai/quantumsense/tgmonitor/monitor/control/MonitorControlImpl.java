package ai.quantumsense.tgmonitor.monitor.control;

import static ai.quantumsense.tgmonitor.monitor.control.MonitorState.LOGGED_IN_PAUSED;
import static ai.quantumsense.tgmonitor.monitor.control.MonitorState.LOGGED_IN_RUNNING;
import static ai.quantumsense.tgmonitor.monitor.control.MonitorState.LOGGED_OUT;

public class MonitorControlImpl implements MonitorControl {

    private String phoneNumber = null;
    private MonitorState state = LOGGED_OUT;
    private Authenticator authenticator;
    private Executor executor;
    private LoginCodeReader loginCodeReader;

    private static MonitorControl instance = null;

    public MonitorControlImpl(Authenticator authenticator, Executor executor, LoginCodeReader loginCodeReader) {
        this.authenticator = authenticator;
        this.executor = executor;
        this.loginCodeReader = loginCodeReader;
        instance = this;
    }

    static MonitorControl get() {
        return instance;
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
    public LoginCodeReader getLoginCodeReader() {
        return loginCodeReader;
    }

    private void illegalState(String msg) {
        throw new IllegalStateException(msg);
    }
}
