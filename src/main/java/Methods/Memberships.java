package Methods;

import Libraries.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Memberships extends BrowserDriver {
    By acceptBtn = By.xpath("//button[contains(@class,'cky-btn-accept')]");
    By acceptBtn2 = By.xpath("//*[@id='site']/div[4]/div[2]/button[1]");
    By memberships = By.xpath("(//span[contains(text(),'Purchase your tickets')])[2]");
    By membershipButton = By.xpath("//a[@href='/en/zoo-ecomuseum-membership/']");
  
    
//    By purchaseMembership = By.xpath("//a[contains(@class,'bg-color-green-80') and contains(@href, '/en/zoo')]");
    By purchaseMembership = By.xpath("//span[contains(text(),'Purchase my membership')]");
  
  
//    By clickMembership = By.xpath("//*[@id='page-index-detail']");
//    By purchaseMembership2 = By.cssSelector();
    
    By individualMembership = By.xpath("//div[contains(@class,'item') and .//div[normalize-space()='Individual membership']]");
    By studentMembership =By.xpath("//div[contains(@class,'item') and .//div[normalize-space()='Student membership']]");
    By familyMembership = By.xpath("//div[contains(@class,'item') and .//div[normalize-space()='Family membership']]");
    By lifeMembership = By.xpath("//div[contains(@class,'item') and .//div[normalize-space()='Life membership']]");
//    
    By logo = By.xpath("//a[@href='https://zooecomuseum.ca/']/img");
//    By individualMembership = By.xpath("//*[@id='page-index-detail']/main/article/div[2]/section[3]/div/div/div/a");
//    By studentMembership =By.xpath("//div[contains(@class,'item item2')]/div[@class='item_radio']");
//    By familyMembership = By.xpath("//*[contains(@id,'frmaa')]/div[2]/div[1]/div[1]/div[5]/div[3]");
//    By lifeMembership = By.xpath("//*[contains(@id,'frmaa')]/div[2]/div[1]/div[1]/div[5]/div[4]");
    By firstName = By.xpath("//*[@id='firstname']");
    By lastName = By.xpath("//*[@id='lastname']");
    By email = By.xpath("//*[@id='email']");
    By selectDate = By.xpath("//*[@id='birthdate']");
    By maleSelect = By.xpath("//*[@id='gender']/div[2]/table/tbody/tr/td[1]/label");
    By femaleSelect = By.xpath("//*[@id='gender']/div[1]/table/tbody/tr/td[1]/label");
    By frenchSelect = By.xpath("//*[@id='language']/div[2]/table/tbody/tr/td[1]/label");
    By checkBox1 = By.xpath("//*[@for='additional_question_1']");
    By continueBtn = By.xpath("//div[@class='button th_bt_next']");
    By addMember = By.cssSelector(".button.bt_add_member");
    By homePage = By.id("ps1444467860");
    By errorMessage = By.xpath("//*[@id='div_frmaaf37a1_msg_error']");



    public Memberships(WebDriver driver)
    {
        super(driver);
    }
    public Memberships()
    {

    }

    @Override
    public WebElement getQuantityInput() {
        return null;
    }

    @Override
    public String getFieldValue() {
        return "";
    }
    public String getErrorMessage ()
    {
        WebElement element = driver.findElement(errorMessage);
        return element.getText();
    }

    public void submitCommands1() throws InterruptedException {
        clickWait2(acceptBtn);
        clickWait2(acceptBtn2);
        System.out.println("Waiting starts for the membership button click");
        waitPageToLoadAndClick(memberships);
        waitAndClick(membershipButton);
       
        System.out.println(driver.getCurrentUrl());
//        clickWait2(clickMembership);
        
        System.out.println("Logo checking");
        System.out.println(driver.getCurrentUrl());
       
       
     // Switch to the new tab
        // 1. Record the handle of the current (original) window
        String originalWindow = driver.getWindowHandle();

        // 2. Click the link that opens the new tab
        clickWait2(purchaseMembership);

        // 3. Wait until the new tab opens (total windows count changes from 1 to 2)
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 4. Switch driver focus to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

    
                

    
        waitPageToLoadAndClick(individualMembership);
//        System.out.println(driver.findElements(studentMembership).size());
         waitAndClick(studentMembership);
        waitAndClick(familyMembership);
        waitAndClick(lifeMembership);
        //Positive Tests for membership
        clickAndInput(firstName, "John");
        clickAndInput(lastName, "Doe");
        clickAndInput(email, "JohnDoe@gmail.com");
       
        clickAndInput(selectDate, "2005-01-20");
        clickWait2(maleSelect);
        clickWait2(femaleSelect);
        clickWait2(frenchSelect);
        bypass(checkBox1);
        
        
    }
     public void submitCommands2()
     {
         clickWait2(continueBtn);
         clickWait2(addMember);
         bypass(continueBtn);
     }



        //Validation test
        public void submitCommands3() {
            bypass(continueBtn);
            bypass(continueBtn);
            clickWait2(homePage);

        }












    }
