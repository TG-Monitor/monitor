package ai.quantumsense.tgmonitor.monitor.control;

public class MonitorControlImplFactory implements MonitorControlFactory {
    @Override
    public MonitorControl getMonitorControl() {
        MonitorControl monitorControl = MonitorControlImpl.get();
        if (monitorControl == null)
            throw new RuntimeException("Attempting to get instance of " + MonitorControl.class.getSimpleName() + ", but has not yet been initialized");
        return monitorControl;
    }
}
