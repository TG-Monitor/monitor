package ai.quantumsense.tgmonitor.monitor;

public interface Telegram {

    /**
     * Log in into Telegram with the user account associated with the specified
     * phone number.
     *
     * If the system is already logged in, then a RuntimeException is thrown.
     *
     * @param phoneNumber Phone number associated with user's Telegram account.
     * @param loginCodePrompt Callback provided by UI to prompt user for login code.
     */
    void login(String phoneNumber, LoginCodePrompt loginCodePrompt);

    /**
     * Log out from Telegram.
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
     * Get the phone number that was used to log in into Telegram.
     *
     * If system is currently not logged in, a RuntimeException is thrown.
     *
     * @return Phone number (e.g. "+41791231212")
     */
    String getPhoneNumber();

    /**
     * Start reading incoming messages in  groups and channels that are
     * currently set in the Peers repository.
     *
     * If system is already reading messages, a RuntimeException is thrown.
     *
     * If the system is not logged in into Telegram, a RuntimeException is
     * thrown.
     */
    void start();

    /**
     * Stop reading incoming messages in the groups and channels.
     *
     * If system is currently not reading messages, a RuntimeException is thrown.
     *
     * If the system is not logged in into Telegram, a RuntimeException is
     * thrown.
     */
    void stop();

    /**
     * Test if the system is currently reading messages.
     *
     * @return "true" if currently reading, and "false" otherwise.
     */
    boolean isRunning();
}
