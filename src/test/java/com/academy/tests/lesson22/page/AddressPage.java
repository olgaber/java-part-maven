package com.academy.tests.lesson22.page;

import com.academy.tests.lesson22.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( css = "ul.last_item.item.box li.address_update a[title=\"Update\"]")
    private WebElement updateButton;

    public FormAddressPage clickUpdateButton(){
        updateButton.click();
        return new FormAddressPage(driver);
    }


}
