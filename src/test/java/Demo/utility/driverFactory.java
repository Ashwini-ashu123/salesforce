package Demo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {

    public static WebDriver initializeDriver(String browserName) {
        WebDriver driver = null;

        switch (browserName.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
                default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);

        }

        driver.manage().window().maximize();
        return driver;
    }
}
