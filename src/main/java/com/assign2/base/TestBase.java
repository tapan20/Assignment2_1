package com.assign2.base;

import com.assign2.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            FileReader reader = new FileReader(
                    "/Users/tapan.khimani/Documents/workspace/Cloud/com.assignment2/src/main/java/com/assign2/config/config.properties");
            prop = new Properties();
            prop.load(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void init() {
        String browserName = prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/tapan.khimani/Documents/My Work/Selenium/chromedriver");
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}


