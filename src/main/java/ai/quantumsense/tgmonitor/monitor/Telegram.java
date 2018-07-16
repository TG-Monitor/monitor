package ai.quantumsense.tgmonitor.monitor;

public interface Telegram {

    /**
     * Log system into Telegram with the specified user phone number.
     *
     * If the system is already logged in, then a RuntimeException is thrown.
     *
     * @param phoneNumber Phone number associated with user's Telegram account.
     */
    void login(String phoneNumber);

    /**
     * Log out system from Telegram.
     *
     * If the system is currently reading messages, then reading is stopped
     * before logging out.
     *
     * If the system is already logged out, then this method does nothing.
     */
    void logout();

    /**
     * Test if the system is currently logged in into Telegram.
     *
     * @return "true" if the user is logged in, and "false" otherwise.
     */
    boolean isLoggedIn();

    /**
     * Start reading the incoming messages in the peers (groups and channels)
     * that are currently set in the Peers entities.
     *
     * If the system is already reading, a RuntimeException is thrown.
     *
     * If the system is not logged in into Telegram, a RuntimeException is
     * thrown.
     */
    void startReading();

    /**
     * Stop reading the incoming messages in the peers (groups and channels)
     * that are currently set in the Peers entities.
     *
     * If the system is currently not reading, a RuntimeException is thrown.
     *
     * If the system is not logged in into Telegram, a RuntimeException is
     * thrown.
     */
    void stopReading();

    /**
     * Test if the system is currently reading messages.
     *
     * @return "true" if currently reading, and "false" otherwise.
     */
    boolean isReading();
}
