package Libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

public class CommonFunctions {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
    }

    public CommonFunctions() {
    }


    public void waitAndClick(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (TimeoutException e) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void bypass(By a) {
        WebElement ticketLink = wait.until(
                ExpectedConditions.elementToBeClickable(a)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ticketLink);
    }

    public void switchWindows() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = wait.until(d -> driver.getWindowHandle());

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        String newWindow = wait.until(d -> d.getWindowHandles().stream()
                .filter(handle -> !handle.equals(currentWindow))
                .findFirst()
                .orElse(null));
        driver.switchTo().window(newWindow);
    }

    private WebElement firstClickableElement(By locator) {
        for (WebElement element : driver.findElements(locator)) {
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
        }
        return null;
    }

    public void clickWait2(By a) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(a));
        try {
            element.click();

        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", element);

        }


    }

    private boolean isDisabled(WebElement element) {
        String disabled = element.getAttribute("disabled");
        String ariaDisabled = element.getAttribute("aria-disabled");
        String className = element.getAttribute("class");

        return disabled != null
                || "true".equalsIgnoreCase(ariaDisabled)
                || (className != null && className.toLowerCase().contains("disabled"));
    }

    public int clickPlusButton(By increaseButton, int timesToClick) {
        int clicks = 0;

        while (clicks < timesToClick) {
            WebElement button = firstClickableElement(increaseButton);

            if (button == null || isDisabled(button)) {
                return clicks;

            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

            try {
                button.click();

            } catch (ElementNotInteractableException e) {
                js.executeScript("arguments[0].click();", button);

            }
            clicks++;


        }
        return clicks;

    }

    public void clickWait1(By a) {
        driver.findElement(a).click();
    }

    public void sendKeys(By a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
//        js.executeScript("arguments[0].removeAttribute('readonly');", a);
        String userInput = scanner.nextLine(); //reads text input
        driver.findElement(a).sendKeys(userInput);

    }

    public void textInput(By a, String b) {
        wait.until(ExpectedConditions.elementToBeClickable(a));
        driver.findElement(a).sendKeys(b);
    }

    public void shadowRoot(WebElement element) {
        element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return document.querySelector('custom-component').shadowRoot.querySelector('button.submit');");
        element.click();
    }

    public void unboundedString(WebElement element, int length) {
        String massiveString = "A".repeat(length);
        element.clear();
        element.sendKeys(massiveString);
    }

    public void unboundedAmount(WebElement element, String a) {
        element.clear();
        element.sendKeys(a);

    }

    public WebElement getQuantityInput(By a) {
        return driver.findElement(a);
    }


    public String getFieldValue(By a) {
        return driver.findElement(a).getAttribute("value");
    }

    public void hiddenElement(By a) {

       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(a));
        new Actions(driver).moveToElement(element).perform();
        element.click();
    }

    public void scrollIntoView(By a) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", a);
    }

}













