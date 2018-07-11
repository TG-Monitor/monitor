package ai.quantumsense.tgmonitor.monitor.control;

public interface Executor {
    void startAll();
    void stopAll();
    void start(String peer);
    void stop(String peer);
}
