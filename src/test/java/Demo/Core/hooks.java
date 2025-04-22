package Demo.Core;

import Demo.utility.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class hooks extends testContext {

    @Before
    public void setUp() {
        WebDriver driver = driverFactory.initializeDriver("firefox");
        setDriver(driver); // ✅ update testContext

        System.out.println("Driver initialized: " + (driver != null ? "YES" : "NO"));

        try {
            driver.get("https://www.google.com"); // Load a test page
            System.out.println("Browser Title: " + driver.getTitle());
        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        WebDriver driver = getDriver(); // ✅ Get driver from testContext
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
