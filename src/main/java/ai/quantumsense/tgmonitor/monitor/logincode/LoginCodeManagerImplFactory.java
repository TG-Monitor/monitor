package ai.quantumsense.tgmonitor.monitor.logincode;

public class LoginCodeManagerImplFactory implements LoginCodeManagerFactory{
    @Override
    public LoginCodeManager getLoginCodeManager() {
        LoginCodeManager instance = LoginCodeManagerImpl.get();
        if (instance == null)
            throw new RuntimeException("Attempting to get instance of " + LoginCodeManager.class.getSimpleName() + ", but has not yet been initialized");
        return instance;
    }

    @Override
    public void registerLoginCodeReader(LoginCodeReader loginCodeReader) {
        new LoginCodeManagerImpl(loginCodeReader);
    }
}
