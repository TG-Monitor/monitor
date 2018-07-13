package ai.quantumsense.tgmonitor.monitor.control;

public class MonitorControlImpl implements MonitorControl {

    private Authenticator authenticator;
    private Executor executor;
    private String phoneNumber = null;
    private boolean loggedIn = false;

    private static MonitorControl instance = null;

    public MonitorControlImpl(Authenticator authenticator, Executor executor) {
        this.authenticator = authenticator;
        this.executor = executor;
        instance = this;
    }

    static MonitorControl get() {
        return instance;
    }

    @Override
    public void login(String phoneNumber) {
        if (loggedIn)
            throw new RuntimeException("Attempting to log in, but already logged in");
        authenticator.login(phoneNumber);
        this.phoneNumber = phoneNumber;
        loggedIn = true;
    }

    @Override
    public void logout() {
        if (!loggedIn)
            throw new RuntimeException("Attempting to log out, but already logged out");
        authenticator.logout();
        phoneNumber = null;
        loggedIn = false;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
