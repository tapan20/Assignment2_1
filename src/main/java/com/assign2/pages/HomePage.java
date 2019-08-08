package com.assign2.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.assign2.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.assign2.base.TestBase;
import org.testng.Assert;

public class HomePage extends TestBase {

    TestUtil testUtil = new TestUtil();

    public String keyword = "Hotel";

    public String actualTitle = driver.getTitle();

    public String screenShotPath = "/Users/tapan.khimani/IdeaProjects/comassignment2/src/snaps/";


    @FindBy(xpath = "//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[2]/a")
    WebElement hotelsTab;


    @FindBy(xpath = "//*[@id=\"s2id_location\"]/a/span[1]")
    WebElement hotelSearch;


    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement searchTxt;

    @FindBy(tagName = "a")
    List<WebElement> links;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")
    WebElement searchResults;

    @FindBy(xpath = "//*[@id=\"dpd1\"]/div/input")
    WebElement checkInDate;

    @FindBy(xpath = "/html/body/div[14]/div[1]")
    WebElement checkOutDate;


    @FindBy(xpath = "//*[@id=\"dpd2\"]/div/input")
    WebElement checkoutTxt;

    @FindBy(xpath = "/html/body/div[13]/div[1]")
    WebElement dateWidget;

    @FindBy(className = "day  active")
    WebElement todayDate;

    @FindBy(className = "form form-control input-lg hcheckin")
    WebElement checkIn;

    @FindBy(xpath = "//*[@id=\"htravellersInput\"]")
    WebElement person;

    @FindBy(className = "hchildInput")
    WebElement child;

    @FindBy(id = "hchildPlusBtn")
    WebElement childInc;

    @FindBy(xpath = "//*[@id=\"thhotels\"]/form/div[5]/button")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[1]/div/form/div[5]/button")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")
    WebElement searchElement;

    @FindBy(xpath = "//*[@id=\"listing\"]/tbody/tr/td/div[3]/form/button")
    WebElement detailsBtn;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[2]/a")
    WebElement currency;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[2]/ul/li[4]/a")
    WebElement selectedCurrency;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/ul/li/a")
    WebElement language;

    @FindBy(xpath = "//*[@id=\'de\']")
    WebElement selectedLanguage;

    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/a/i")
    WebElement myAccount;

    @FindBy(name = "  Sign Up")
    WebElement signUp;


    public HomePage() {

        PageFactory.initElements(driver, this);

    }

    public void printAllLinks() throws InterruptedException {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int size = links.size();
        System.out.println("Count of Links : " + size);
        Thread.sleep(3500);

        for (int i = 0; i < links.size(); i++) {
            try {
                System.out.println(links.get(i).getAttribute("href"));
                links.get(i).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void waterMarkText() {
        System.out.println("PlaceHolder is : " + hotelSearch.getText());

    }

    public void searchFunctionality() throws InterruptedException {


        Thread.sleep(10000);


        hotelSearch.click();
        // send keys hotel
        Thread.sleep(2500);
        searchTxt.sendKeys(keyword);
        screenShot();
//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        Thread.sleep(4500);
        // click on the first search results
        searchResults.click();
        //hotelSearch.sendKeys(Keys.TAB);


        // check in date selection
        // dynamic select today's date
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = new Date();
        System.out.println("Date object creation");
        String today = dateFormat2.format(date2);
        // select check in date
        checkInDate.click();
        Thread.sleep(3500);
        checkInDate.sendKeys(today);

        Thread.sleep(3500);
        screenShot();
//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        checkInDate.sendKeys(Keys.TAB);


        // check out date selection
        // dynamic select tomorrow's date
        //checkOutDate.click();

        Date dt = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        dt = calendar.getTime();
        String tomorrowDate = dateFormat2.format(dt);
        System.out.println(tomorrowDate);

        checkoutTxt.sendKeys(tomorrowDate);
        Thread.sleep(5000);
        screenShot();

//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // checkOutDate.sendKeys(Keys.TAB);
        // Thread.sleep(5000);


        // total person
        person.click();
        Thread.sleep(3500);
        // child.click();
        Thread.sleep(2500);
        childInc.click();
        screenShot();
//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        // Click on Search
        submitBtn.click();


        hotelSearch.click();
        // send keys hotel
        Thread.sleep(2500);
        searchTxt.sendKeys(keyword);
        Thread.sleep(2500);
        // click on the first search results
        searchElement.click();


        Thread.sleep(4500);
        submit.click();
        screenShot();

//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Thread.sleep(3500);
        detailsBtn.click();
        screenShot();

//        try {
//            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Assert


        System.out.println("Title is" + actualTitle);
        Assert.assertEquals(driver.getTitle(), "", "Assertion Fails");


        //hover using action.
        // Select language as German
        Actions action = new Actions(driver);
        action.moveToElement(language).build().perform();
        Thread.sleep(2500);
        action.moveToElement(language).click(selectedLanguage).build().perform();

        // action.moveToElement(selectedLanguage).click().build().perform();


        //hover using action.
        //Select currency as Euro
        Actions action1 = new Actions(driver);
        action1.moveToElement(currency).build().perform();
        Thread.sleep(2500);
        //action1.moveToElement(selectedCurrency).click().build().perform();
        action.moveToElement(selectedCurrency).click(selectedCurrency).build().perform();

        Thread.sleep(5000);
        // Sign up
//        myAccount.click();
//        Thread.sleep(3500);
//        System.out.println("Reached Sign up");
//        signUp.click();


    }

    public void screenShot() {

        try {
            testUtil.takeSnapShot(this.driver, screenShotPath + System.currentTimeMillis() + "test.png");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

