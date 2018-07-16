package ai.quantumsense.tgmonitor.monitor;

import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

public class MonitorImpl implements Monitor {

    private Telegram tg;
    private String phoneNumber = null;

    public MonitorImpl(Telegram tg, ServiceLocator<Monitor> monitorLocator) {
        this.tg = tg;
        monitorLocator.registerService(this);
    }

    @Override
    public void login(String phoneNumber) {
        if (isLoggedIn())
            throw new RuntimeException("Attempting to log in, but already logged in");
        tg.login(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void logout() {
        if (!isLoggedIn())
            throw new RuntimeException("Attempting to log out, but already logged out");
        tg.logout();
        phoneNumber = null;
    }

    @Override
    public boolean isLoggedIn() {
        return tg.isLoggedIn();
    }

    @Override
    public void start() {
        if (tg.isRunning())
            throw new RuntimeException("Attempting to start monitor, but is already running");
        tg.start();

    }

    @Override
    public void stop() {
        if (!tg.isRunning())
            throw new RuntimeException("Attempting to stop monitor, but is currently not running");
        tg.stop();
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
