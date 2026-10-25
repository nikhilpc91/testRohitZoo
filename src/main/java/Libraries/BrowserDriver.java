package Libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BrowserDriver extends CommonFunctions implements UI {

    public BrowserDriver(WebDriver driver) {
        super(driver);

    }

    public BrowserDriver() {
    }

    public void browser() {
        switch (browser) {
            case "chrome":
                ChromeOptions options1 = new ChromeOptions();
//                options1.addArguments("--headless=new");
                options1.addArguments("--window-size=1920,1020");
                driver = new ChromeDriver(options1);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                FirefoxOptions options3 = new FirefoxOptions();
//                options3.addArguments("--headless");
                driver = new FirefoxDriver();
                break;
            case "edge":
                EdgeOptions options4 = new EdgeOptions();
                options4.addArguments("--headless=new");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid Browser, Input Valid Browser");
                return;


        }
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(link);
        System.out.println("Loaded Page:" + driver.getTitle() + driver.getCurrentUrl());

    }

    public abstract WebElement getQuantityInput();


    public abstract String getFieldValue();

}



//
//package Libraries;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public abstract class BrowserDriver extends CommonFunctions implements UI {
//
//    public BrowserDriver(WebDriver driver) {
//        super(driver);
//    }
//
//    public BrowserDriver() {
//        super();
//    }
//
//    public void browser() {
//
//        // Initialize the selected browser
//        switch (browser.toLowerCase()) {
//
//            case "chrome":
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--window-size=1920,1020");
//                driver = new ChromeDriver(chromeOptions);
//                break;
//
//            case "safari":
//                driver = new SafariDriver();
//                break;
//
//            case "firefox":
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                driver = new FirefoxDriver(firefoxOptions);
//                break;
//
//            case "edge":
//                EdgeOptions edgeOptions = new EdgeOptions();
//                driver = new EdgeDriver(edgeOptions);
//                break;
//
//            default:
//                throw new IllegalArgumentException(
//                    "Invalid browser: " + browser
//                );
//        }
//
//        // Initialize Selenium helpers
//        js = (JavascriptExecutor) driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        // Set page-load timeout
//        driver.manage().timeouts()
//              .pageLoadTimeout(Duration.ofSeconds(60));
//
//        // Navigate to the requested URL
//        System.out.println("Opening URL: " + link);
//        driver.get(link);
//
//        // Wait until the main document finishes loading
//        wait.until(d ->
//            "complete".equals(
//                ((JavascriptExecutor) d)
//                    .executeScript("return document.readyState")
//            )
//        );
//
//        System.out.println("Page loaded successfully.");
//        System.out.println("Title: " + driver.getTitle());
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        System.out.println("Ready state: " +
//            js.executeScript("return document.readyState"));
//    }
//
//    public abstract WebElement getQuantityInput();
//
//    public abstract String getFieldValue();
//}
