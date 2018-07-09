package ai.quantumsense.tgmonitor.monitor;

public interface Executor {
    void startAll();
    void stopAll();
    void start(String peer);
    void stop(String peer);
}
