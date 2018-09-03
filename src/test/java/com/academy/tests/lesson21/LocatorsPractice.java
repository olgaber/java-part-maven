package com.academy.tests.lesson21;

import com.academy.lesson18.manager.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LocatorsPractice {

//    a) выбрать input типа checkbox.
//    b) выбрать input типа checkbox, НЕ отмеченный.
//            c) Найти все элементы с id=message или message-*.
//    d) Найти все элементы с id=message-*.
//    e) Найти все ссылки с расширением href="...zip".
//            f) Найти все элементы с атрибутом data-action, содержащим delete в списке (через пробел).
//    g) Найти все элементы, у которых ЕСТЬ атрибут data-action, но он НЕ содержит delete в списке (через пробел).
//    h) Выбрать все чётные элементы списка #messages.
//            i) Выбрать один элемент сразу за заголовком h3#widget-title на том же уровне вложенности.
//    k) Выбрать все ссылки, следующие за заголовком h3#widget-title на том же уровне вложенности.
//    l) Выбрать ссылку внутри последнего элемента списка #messages.
//

    private WebDriver driver;
    private String baseUrl;
    private PropertyManager propertyManager = PropertyManager.getInstance();
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String PROP_FILE_NAME = "java-part.properties";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", propertyManager.getProperty("chrome.driver"));
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
//        driver = new FirefoxDriver();

        baseUrl = propertyManager.getProperty("automation.baseurl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void findXpath(){
        driver.get(baseUrl);

//        a) выбрать input типа checkbox.
        driver.findElement(By.cssSelector("input[type='checkbox']"));
        driver.findElement(By.xpath("//input[@type='checkbox']"));

//        b) выбрать input типа checkbox, НЕ отмеченный.
        //driver.findElement(By.cssSelector("input[type='checkbox']:not(:checked)")); ///WHY???
        driver.findElement(By.xpath("//input[@type='checkbox' and not(@checked)]"));

//        c) Найти все элементы с id=message или message-*.
        driver.findElements(By.cssSelector("[id|='message']"));
        driver.findElement(By.xpath("//*[@id='message' or starts-with(@id, 'message-')]"));

//        d) Найти все элементы с id=message-*.
        driver.findElement(By.cssSelector("[id^='message-']"));
        driver.findElement(By.xpath("//*[starts-with(@id, 'message-')]"));

//        e) Найти все ссылки с расширением href="...zip".
        driver.findElement(By.cssSelector("a[href$='.zip']"));
        driver.findElement(By.xpath("//a[contains(@href, '.zip')]"));

//        f) Найти все элементы с атрибутом data-action, содержащим delete в списке (через пробел).
        driver.findElement(By.cssSelector("[data-action ~= delete]"));
        driver.findElement(By.xpath("//*[contains(@data-action, ' delete')]"));//??

//        g) Найти все элементы, у которых ЕСТЬ атрибут data-action, но он НЕ содержит delete в списке (через пробел).
        driver.findElement(By.cssSelector("[data-action]:not([data-action~='delete']"));
       // driver.findElement(By.xpath("")); //??

//        h) Выбрать все чётные элементы списка #messages.
        driver.findElement(By.cssSelector("#messages li:nth-child(2n)"));
        driver.findElement(By.xpath("//*[@id='messages']/li[position() mod 2 = 0]"));

//        i) Выбрать один элемент сразу за заголовком h3#widget-title на том же уровне вложенности.
        driver.findElement(By.cssSelector("h3#widget-title+*"));
        driver.findElement(By.xpath("//h3/following-sibling::*"));

//        k) Выбрать все ссылки, следующие за заголовком h3#widget-title на том же уровне вложенности.
        driver.findElement(By.cssSelector("h3#widget-title ~ a"));
        driver.findElement(By.xpath("//h3/following-sibling::a"));

//        l) Выбрать ссылку внутри последнего элемента списка #messages.
        driver.findElement(By.cssSelector("#messages li:last-child a"));
        driver.findElement(By.xpath("//*[@id='messages']/li[last()]/a"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
//        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
