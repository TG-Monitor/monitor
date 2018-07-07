package ai.quantumsense.tgmonitor.monitor;

public interface Executor {
    void startAll();
    void stopAll();
    void startPeer(String peer);
    void stopPeer(String peer);
}
