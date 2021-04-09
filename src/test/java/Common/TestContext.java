package Common;

public class TestContext {

    private DriverSetup driverSetup;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        driverSetup = new DriverSetup();
        pageObjectManager = new PageObjectManager(driverSetup.getDriver());
    }

    public DriverSetup getDriverSetup() {
        return driverSetup;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}
