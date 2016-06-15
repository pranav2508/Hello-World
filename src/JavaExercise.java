
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;



import java.util.ArrayList;

import java.util.List;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by pranav on 24/5/16.
 */
public class JavaExercise {

    WebDriver _driver = new FirefoxDriver();
    @Before
    public void amazonUrl() {

        _driver.get("https://amazon.in");
        _driver.manage().window().maximize();
    }


    @Test
    public void searchDropdownBox() {


        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dropDownBox = _driver.findElement(By.id("searchDropdownBox"));
        dropDownBox.click();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1). Verifying the elements of search dropdown which is called All
        WebElement sel = _driver.findElement(By.id("searchDropdownBox"));
        List<WebElement> options = sel.findElements(By.tagName("option"));
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : options) {

            actualOptions.add(option.getText());
        }


        Assert.assertTrue(actualOptions.contains("All Categories"));
        Assert.assertTrue(actualOptions.contains("Amazon Fashion"));
        Assert.assertTrue(actualOptions.contains("Appliances"));
        Assert.assertTrue(actualOptions.contains("Baby"));
        Assert.assertTrue(actualOptions.contains("Beauty"));
        Assert.assertTrue(actualOptions.contains("Books"));
        Assert.assertTrue(actualOptions.contains("Car & Motorbike"));
        Assert.assertTrue(actualOptions.contains("Clothing & Accessories"));
        Assert.assertTrue(actualOptions.contains("Computers & Accessories"));
        Assert.assertTrue(actualOptions.contains("Electronics"));
        Assert.assertTrue(actualOptions.contains("Furniture"));
        Assert.assertTrue(actualOptions.contains("Gift Cards"));
        Assert.assertTrue(actualOptions.contains("Grocery & Gourmet Foods"));
        Assert.assertTrue(actualOptions.contains("Health & Personal Care"));
        Assert.assertTrue(actualOptions.contains("Home & Kitchen"));
        Assert.assertTrue(actualOptions.contains("Industrial & Scientific"));
        Assert.assertTrue(actualOptions.contains("Jewellery"));
        Assert.assertTrue(actualOptions.contains("Kindle Store"));
        Assert.assertTrue(actualOptions.contains("Luggage & Bags"));
        Assert.assertTrue(actualOptions.contains("Movies & TV Shows"));
        Assert.assertTrue(actualOptions.contains("Music"));
        Assert.assertTrue(actualOptions.contains("Musical Instruments"));
        Assert.assertTrue(actualOptions.contains("Office Products"));
        Assert.assertTrue(actualOptions.contains("Pet Supplies"));
        Assert.assertTrue(actualOptions.contains("Shoes & Handbags"));
        Assert.assertTrue(actualOptions.contains("Software"));
        Assert.assertTrue(actualOptions.contains("Sports, Fitness & Outdoors"));
        Assert.assertTrue(actualOptions.contains("Toys & Games"));
        Assert.assertTrue(actualOptions.contains("Video Games"));
        Assert.assertTrue(actualOptions.contains("Watches"));
        _driver.quit();


    }

    //2). Search for the mobile and add it into the cart and proceed for the payment option
    @Test
    public void buyMobileDevice() {


        WebElement searchBox = _driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();
        searchBox.sendKeys("samsung mobile j7");
        searchBox.submit();

        WebElement searchButton = _driver.findElement(By.className("nav-input"));
        searchButton.click();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //assertEquals("\"samsung galaxy j7\"", _driver.findElement(By.xpath("//span[@id='editableBreadcrumbContent']//a[@id='bcKwText']")).getText());


        WebElement findElement = _driver.findElement(By.xpath("//div[@id='atfResults']//li[4]//h2"));
//        assertEquals("Samsung Galaxy J7 SM-J700F (White)", _driver.findElement(By.xpath("//div[@id='atfResults']//li[4]//h2")).getText());
        findElement.click();


        _driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        String winHandlerBefore = _driver.getWindowHandle();
        for (String winHandle : _driver.getWindowHandles()) {
            _driver.switchTo().window(winHandle);
        }
        WebElement buyButton = _driver.findElement(By.xpath("//input[@id='buy-now-button']"));
        buyButton.click();

        assertEquals("Login", _driver.findElement(By.xpath("//div//h1")).getText());
        assertEquals("Email or mobile phone number", _driver.findElement(By.xpath("//div//label[@for='ap_email']")).getText());
        assertEquals("Password", _driver.findElement(By.xpath("//div//label[@for='ap_password']")).getText());
        WebElement login = _driver.findElement(By.id("ap_email"));
        login.click();
        login.sendKeys("samueljoseph0001212@gmail.com");


        WebElement passwd = _driver.findElement(By.id("ap_password"));
        passwd.click();
        passwd.sendKeys("SAMUEL_joseph");
        //passwd.submit();

        WebElement loginButton = _driver.findElement(By.xpath("//input[@id='signInSubmit']"));

        assertTrue(loginButton.isDisplayed());

        loginButton.click();

        assertEquals("Select a delivery address", _driver.findElement(By.xpath("//div//h1")).getText());
        WebElement userName = _driver.findElement(By.id("enterAddressFullName"));
        userName.click();
        userName.sendKeys("Samuel Joseph");

        WebElement mobileN = _driver.findElement(By.id("enterAddressPhoneNumber"));
        mobileN.click();
        mobileN.sendKeys("9028388409");

        WebElement pinCode = _driver.findElement(By.id("enterAddressPostalCode"));
        pinCode.click();
        pinCode.sendKeys("411052");

        WebElement addressLine = _driver.findElement(By.id("enterAddressAddressLine1"));
        addressLine.click();
        addressLine.sendKeys("Karve Nagar, Vittal Mandir road,Pune");

        WebElement cityAdd = _driver.findElement(By.id("enterAddressCity"));
        cityAdd.click();
        cityAdd.sendKeys("Pune");

        WebElement state = _driver.findElement(By.id("enterAddressStateOrRegion"));
        state.click();
        state.sendKeys("Maharashtra");

        WebElement addrType = _driver.findElement(By.id("AddressType"));
        Select addressT = new Select(addrType);
        addressT.selectByValue("COM");

        WebElement continueButton = _driver.findElement(By.xpath("//span//input"));
        continueButton.click();

/*        assertEquals("Cash on Delivery (COD)", _driver.findElement(By.id("Cash on Delivery (COD)")).getText());
        WebElement radioButton = _driver.findElement(By.xpath("//div//input[@value='cashOnDeliveryCash']"));
        Select radioB = new Select(radioButton);
        radioButton.click();

        WebElement continueB = _driver.findElement(By.id("continue-bottom"));
        assertTrue(continueB.isDisplayed()); */


        _driver.close();
        _driver.switchTo().window(winHandlerBefore);

        //_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        _driver.quit();

    }

    @Test
   public void sellWithAmazon() {

       WebElement sellTab = _driver.findElement(By.partialLinkText("Sell"));
       sellTab.click();

        WebElement image = _driver.findElement(By.xpath("//img[@alt='Benefits of Selling on Amazon']"));
        assertTrue(image.isDisplayed());

        WebElement image1 = _driver.findElement(By.xpath("//img[@usemap='#SOA-hero-banner']"));
        assertTrue(image1.isDisplayed());

        WebElement image2 = _driver.findElement(By.xpath("//img[@usemap='#SOA-pricing']"));
        assertTrue(image2.isDisplayed());

        WebElement registerNow = _driver.findElement(By.xpath("//map//area[@alt='SOA-Hero-register']"));
        registerNow.click();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement continueKey = _driver.findElement(By.id("continue-input"));
        continueKey.click();

        assertEquals("THERE WAS A PROBLEM", _driver.findElement(By.xpath("//h6")).getText());

        WebElement headerMsg = _driver.findElement(By.id("urp-helpnode-one"));
        headerMsg.getText();
        System.out.println("Header message is : " + headerMsg.getText());


        _driver.quit();
   }

   @Test
     public void dropDownList() {

       WebElement dropdownElement = _driver.findElement(By.id("nav-link-shopall"));
       dropdownElement.click();

       WebElement headings = _driver.findElement(By.xpath("//h2"));
       headings.getText();
       System.out.println(headings.getText());
       headings.getLocation();
       _driver.quit();


   }
}
