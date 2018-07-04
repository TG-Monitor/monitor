package ai.quantumsense.tgmonitor.monitor;

public interface Executor {
    void start(int interval);
    void pause();
    boolean isRunning();
}
