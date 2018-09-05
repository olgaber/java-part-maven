package com.academy.tests.lesson22.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Sign out'])[1]/preceding::span[1]")
    private WebElement userLink;

    @FindBy(css = "ul.myaccount-link-list li:nth-child(3) a")
    private WebElement myAddressePanel;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameLinkText() {
        return userLink.getText().trim();
    }

    public HomePage clickSignOut() {
        signOutLink.click();
        return new HomePage(driver);
    }

    public AddressPage clickMyAddress(){
        myAddressePanel.click();
        return new AddressPage(driver);
    }
}