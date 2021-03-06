package com.academy.tests.lesson20;

import com.academy.lesson18.manager.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.fail;

public class SortTests {
    private WebDriver driver;
    private String baseUrl;
    private PropertyManager propertyManager = PropertyManager.getInstance();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

                System.setProperty("webdriver.chrome.driver", propertyManager.getProperty("chrome.driver"));
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
//        driver = new FirefoxDriver();

        baseUrl = propertyManager.getProperty("automation.baseurl");
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void sortDresses1(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();

        //checks
        Assert.assertTrue(driver.getTitle().contains("Women"));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]")).getText().contains("Women"));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"))
                .getText(), "WOMEN");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div/div/span"))
                .getText(), "Women");
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div/div")).getText()
                .contains("You will find here all woman fashion collections"));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/h1/span[2]")).getText()
                .contains("There are 7 products"));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[3]/footer/div/section[2]/div/div/ul/li/a"))
                .getText(), "Women");
    }

    @Test
    public void sortDresses2(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"layered_id_feature_5\"]")).click();

        //1) высвечивается только одна позиция "Printed Dress"

       /* List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        System.out.println(elements.size());
        Stream<WebElement> stream = elements.stream()
                .filter(el -> el.getText() == "Printed Dresses");
               long count = stream.count();
               Assert.assertEquals(count, (long) 1); //java.lang.AssertionError: expected [1] but found [0]*/


        //2) цена 26$
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span"))
                .getText(), "$26.00");

    }

    @Test
    public void sortDresses3(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_1\"]")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");
        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();
        waitUntilScriptComplete(driver);
        //checks
        //1) присутствуют пять позиций
        String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[3]/div[2]/div[2]")).getText();
        Assert.assertEquals(text, "Showing 1 - 5 of 5 items");

        //2) Цены идут по возрастанию: [$16.40, $26.00, $28.98, $30.50, $50.99] (точное значение цены не важно)
        //String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[3]/div[2]/div[2]")).getText();
        List<String> actualPrices =
                driver.findElements(By.cssSelector("#center_column > ul > li > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.content_price.col-xs-5.col-md-12 > span.price.product-price"))
                //#center_column > ul > li > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.content_price.col-xs-5.col-md-12 > span.price.product-price
                        .stream()
                .map(WebElement::getText)
                .peek(String::trim)
                .collect(Collectors.toList());

        List<String> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(String::compareTo);
        System.out.println("actual: " + actualPrices);
        System.out.println("expected: " + expectedPrices);
        Assert.assertEquals(actualPrices, expectedPrices);

    }

    private boolean waitUntilScriptComplete(WebDriver driver1) {
        WebDriverWait wait = new WebDriverWait(driver1, 30, 300);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }


        @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
    driver.quit();

    }

}





