package com.academy.tests.lesson19.automationPractice;

import com.academy.lesson18.manager.PropertyManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LoginTestsFromFile {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private PropertyManager propertyManager = PropertyManager.getInstance();
    private static final String PROP_FILE_NAME = "java-part.properties";

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

        Properties prop = new Properties();

        InputStream is = LoginTestsFromFile.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);

        prop.load(new InputStreamReader(is, "UTF-8"));

        String authDataPath = prop.getProperty("automation.auth.data.exc");

        try (XSSFWorkbook workbook = new XSSFWorkbook(authDataPath)) {
            XSSFSheet sheet = workbook.getSheetAt(0);

        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            XSSFRow row = sheet.getRow(r);

                driver.get(baseUrl);
                driver.findElement(By.linkText("Sign in")).click();
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys(row.getCell(0).getStringCellValue());
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[2]/following::div[1]")).click();
                driver.findElement(By.id("passwd")).clear();
                driver.findElement(By.id("passwd")).sendKeys(row.getCell(1).getStringCellValue());
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
            try {
                String errorMessage = driver.findElement(By.xpath("(//*[@id=\"center_column\"]/div[1]/ol/li)")).getText();
                System.out.println("LOG: " + errorMessage);
                assertEquals(errorMessage,row.getCell(2).getStringCellValue());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        } } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
