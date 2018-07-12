package ai.quantumsense.tgmonitor.monitor.logincode;

public class LoginCodeManagerImpl implements LoginCodeManager {

    private LoginCodeReader loginCodeReader;

    private static LoginCodeManager instance;

    public LoginCodeManagerImpl(LoginCodeReader loginCodeReader) {
        this.loginCodeReader = loginCodeReader;
        instance = this;
    }

    public static LoginCodeManager get() {
        return instance;
    }

    @Override
    public LoginCodeReader getLoginCodeReader() {
        return loginCodeReader;
    }
}
