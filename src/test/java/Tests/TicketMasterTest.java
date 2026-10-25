package Tests;

import Libraries.BrowserDriver;
import Methods.Memberships;
import Methods.TicketPurchase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TicketMasterTest extends BrowserDriver {

    @BeforeMethod
    public void setUpTicketPurchase() {
        // Start a fresh browser for each test
        browser();
    }

    @Test(priority = 1, enabled = false)
    public void runMethod() {
        TicketPurchase ticketMaster = new TicketPurchase(driver);

        ticketMaster.openDonationAmountField();
        unboundedAmount(ticketMaster.getQuantityInput(), "999999999");

        ticketMaster.getQuantityInput()
                .sendKeys(org.openqa.selenium.Keys.TAB);

        String actualValue = ticketMaster.getFieldValue();

        Assert.assertTrue(
            actualValue != null && actualValue.matches("\\d+(\\.\\d+)?"),
            "Donation amount field must contain a numeric value; found: "
                + actualValue
        );

        ticketMaster.completeDonationAndCheckout();
        
    }

    @Test(priority = 2)
    public void runMemberships()throws InterruptedException { {
        Memberships memberships = new Memberships(driver);

        memberships.submitCommands1();
        memberships.submitCommands2();

        String actualMessage = memberships.getErrorMessage();

        String expectedMessage =
            "First name missing" +
            "Last name missing" +
            "Birthdate missing" +
            "Birthdate invalid" +
            "Gender missing";

        Assert.assertEquals(actualMessage, expectedMessage);}
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

  
    
    @Override
    public WebElement getQuantityInput() {
        return null;
    }

    @Override
    public String getFieldValue() {
        return "";
    }
}
