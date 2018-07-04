package ai.quantumsense.tgmonitor.monitor;

public interface Executor {
    void start();
    void pause();
    boolean isRunning();
}
