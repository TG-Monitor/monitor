package ai.quantumsense.tgmonitor.monitor;

import java.util.Set;

public interface Telegram {

    /**
     * Log the user in.
     *
     * If the user is already logged in, then a RuntimeException is thrown.
     *
     * @param phoneNumber Phone number associated with user's Telegram account.
     */
    void login(String phoneNumber);

    /**
     * Log the user out.
     *
     * If any monitors are still running, they are stopped by this method.
     *
     * If the user is already logged out, then this method does nothing.
     */
    void logout();

    /**
     * Test if the user is currently logged in.
     *
     * TODO: it might be possible that the user gets logged out by Telegram,
     * that is, without an explicit call to logout(). In this case, isLoggedIn()
     * would return "false", but the session file would still be there. A new
     * call to login() would handle this correctly, but maybe this case still
     * should be handled explicitly, if it occurs frequently in practice.
     *
     * @return "true" if the user is logged in, and "false" otherwise.
     */
    boolean isLoggedIn();

    /**
     * Start a monitor for the specified peer (group or channel).
     *
     * If a monitor for this peer is already running, then a RuntimeException
     * is thrown.
     *
     * @param peer Username of a Telegram group or channel.
     */
    void start(String peer);

    /**
     * Stop the monitor for the specified peer (group or channel).
     *
     * If there is no monitor running for this peer, then a RuntimeException is
     * thrown.
     *
     * @param peer Username of a Telegram group or channel.
     */
    void stop(String peer);

    /**
     * Returns the number of monitors currently running.
     *
     * Note: there can be at most one monitor running for a given peer.
     *
     * @return Number of currently running monitors.
     */
    int getNumberOfMonitors();

    /**
     * Return usernames of peers for which currently a monitor is running.
     *
     * @return Usernames of monitored peers (groups or channels).
     */
    Set<String> getMonitors();
}
