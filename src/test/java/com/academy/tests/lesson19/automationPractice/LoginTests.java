package com.academy.tests.lesson19.automationPractice;

import com.academy.lesson18.manager.PropertyManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LoginTests {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private PropertyManager propertyManager = PropertyManager.getInstance();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

//        System.setProperty("webdriver.chrome.driver", propertyManager.getProperty("chrome.driver"));
//        driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
        driver = new FirefoxDriver();

        baseUrl = propertyManager.getProperty("automation.baseurl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAuthCorrect() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign out'])[1]/preceding::span[1]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign out'])[1]/preceding::span[1]")).getText(), propertyManager.getProperty("automation.accountname"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Sign out")).click();
    }

    @Test
    public void testAuthIncorrect() throws Exception {

        String[] loginArr = {"olga.berv@yahoo.com", "olga.berv@hotmail.com", "olga.berv@gmail.com", "", "", "olga.berv@gmail.com"};

        String[] passwArr = {"12Azerty!", "Azerty12!", "12!Azerty12!", "", "Azerty12!", ""};

        String[] msgArr = {"Authentication failed.",
                            "Authentication failed.",
                            "Authentication failed.",
                            "An email address required.",
                            "An email address required.",
                            "Password is required."
        };

        for (int i = 0; i < loginArr.length; i++) {

                driver.get(baseUrl);
                driver.findElement(By.linkText("Sign in")).click();
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys(loginArr[i]);
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[2]/following::div[1]")).click();
                driver.findElement(By.id("passwd")).clear();
                driver.findElement(By.id("passwd")).sendKeys(passwArr[i]);
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
            try {
                String errorMessage = driver.findElement(By.xpath("(//*[@id=\"center_column\"]/div[1]/ol/li)")).getText();
                System.out.println("LOG: " + errorMessage);
                assertEquals(errorMessage, msgArr[i]);
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
