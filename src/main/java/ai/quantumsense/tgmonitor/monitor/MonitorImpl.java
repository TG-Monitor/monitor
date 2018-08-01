package ai.quantumsense.tgmonitor.monitor;

import ai.quantumsense.tgmonitor.logincodeprompt.LoginCodePrompt;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

public class MonitorImpl implements Monitor {

    private Telegram tg;
    private String phoneNumber = null;
    private Boolean isLoggedIn = null;

    public MonitorImpl(Telegram tg, ServiceLocator<Monitor> monitorLocator) {
        this.tg = tg;
        monitorLocator.registerService(this);
    }

    @Override
    public void login(String phoneNumber, LoginCodePrompt loginCodePrompt) {
        if (isLoggedIn())
            throw new RuntimeException("Attempting to log in, but already logged in");
        tg.login(phoneNumber, loginCodePrompt);
        this.phoneNumber = phoneNumber;
        isLoggedIn = true;
    }

    @Override
    public void logout() {
        if (!isLoggedIn())
            throw new RuntimeException("Attempting to log out, but already logged out");
        tg.logout();
        phoneNumber = null;
        isLoggedIn = false;
    }

    @Override
    public boolean isLoggedIn() {
        if (isLoggedIn == null)
            isLoggedIn = tg.isLoggedIn();
        return isLoggedIn;
    }

    @Override
    public void start() {
        if (!isLoggedIn())
            throw new RuntimeException("Attempting to start monitor, but not logged in");
        if (isRunning())
            throw new RuntimeException("Attempting to start monitor, but is already running");
        tg.start();

    }

    @Override
    public void stop() {
        if (!isLoggedIn())
            throw new RuntimeException("Attempting to stop monitor, but not logged in");
        if (!isRunning())
            throw new RuntimeException("Attempting to stop monitor, but is currently not running");
        tg.stop();
    }

    @Override
    public boolean isRunning() {
        return tg.isRunning();
    }

    @Override
    public String getPhoneNumber() {
        if (!isLoggedIn())
            throw new RuntimeException("Attempting to get phone number, but not logged in");
        if (phoneNumber == null)
            phoneNumber = tg.getPhoneNumber();
        return phoneNumber;
    }
}
