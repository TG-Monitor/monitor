package ai.quantumsense.tgmonitor.monitor.data;

public class MonitorDataImplFactory implements MonitorDataFactory {

    @Override
    public MonitorData getMonitorData() {
        MonitorData instance = MonitorDataImpl.get();
        if (instance == null)
            throw new RuntimeException("Attempting to get instance of " + MonitorData.class.getSimpleName() + ", but has not yet been initialized");
        return instance;
    }
}
