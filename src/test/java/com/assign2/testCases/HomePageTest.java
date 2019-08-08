package com.assign2.testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.assign2.base.TestBase;
import com.assign2.pages.HomePage;
import com.assign2.util.TestUtil;

public class HomePageTest extends TestBase {
    HomePage homepage;
    TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        init();
        homepage = new HomePage();
        testUtil = new TestUtil();
    }

    @Test(priority = 1)
    public void printAllLinks() throws InterruptedException {
        homepage.printAllLinks();
    }


    @Test(priority = 2)
    public void getWaterMarkTextTest() {
        homepage.waterMarkText();
    }

    @Test(priority = 3)
    public void searchFuncitonTest() throws InterruptedException {
        homepage.searchFunctionality();

    }

    @AfterMethod
    public void teadDown() {
        driver.quit();

    }

}
