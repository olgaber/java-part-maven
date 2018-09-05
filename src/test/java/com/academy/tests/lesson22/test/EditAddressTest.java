package com.academy.tests.lesson22.test;

import com.academy.lesson18.manager.PropertyManager;
import com.academy.tests.lesson22.page.AccountPage;
import com.academy.tests.lesson22.page.AddressPage;
import com.academy.tests.lesson22.page.FormAddressPage;
import com.academy.tests.lesson22.page.HomePage;
import com.academy.tests.lesson22.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditAddressTest extends BaseTest {


    @Test(dataProvider = "authDataProvider")
    public void ema(String email, String password) throws Exception {

        AccountPage accountPage =
                new HomePage(driver)
                        .clickSingIn()
                        .inputEmail(email)
                        .inputPassword(password)
                        .clickSingIn();

        AddressPage addressPage =  new AccountPage(driver)
                .clickMyAddress();
    }

    @DataProvider(name="authDataProvider")
    private Object[][] authProvider() {
        return new Object[][]{
                {PropertyManager.getProperty("automation.username"), PropertyManager.getProperty("automation.password")}
        };
    }

    @Test (dataProvider = "addressDataProvider")
    public void testEditAddress(){
        System.out.println("Start EditAddressTest using PageObject pattern");
        driver.get(baseUrl);
        FormAddressPage formAddressPage = new AddressPage(driver)
                .clickUpdateButton();
        //Object[][] data = addressProvider();
        formAddressPage.modifyFirstName("Maria");
        formAddressPage.modifyLastName("Ivanova");
        formAddressPage.modifyCompany("MyCompany");
        formAddressPage.modifyAddressLine1("Address Line 1");
        formAddressPage.modifyAddressLine2("Address Line 2");
        formAddressPage.modifyCity("City");
        //formAddressPage.modifyState("California");
        formAddressPage.modifyZip("10230");
        //formAddressPage.modifyCountry("US");
        formAddressPage.modifyHomePhone("56203214");
        formAddressPage.modifyMobilePhone("75423695");
        formAddressPage.modifyAdditionalInformation("Additional info");
        formAddressPage.modifyAddressTitle("Address Title");
        formAddressPage.clickSaveButton();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("//span[@class='address_name']")).getText(), "Maria");
        } catch (Error e) {
            verificationErrors.append( e.toString() );
        }



    }

//    @DataProvider(name="addressDataProvider")
//    private Object[][] addressProvider(){
//        return new Object[][]{
//                {"Maria", "Ivanova", "BestCompany", "229 Oliver Street", "line2", "Fort Worth",
//                        "Texas", "76102", "United States", "817-344-7359", "817-344-7345", "modified Additional Information",
//                        "modified address title"}
//        };
//    }


}
