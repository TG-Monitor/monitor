package ai.quantumsense.tgmonitor.monitor.logincode;

public interface LoginCodeManagerFactory {
    LoginCodeManager getLoginCodeManager();
    void registerLoginCodeReader(LoginCodeReader loginCodeReader);
}
