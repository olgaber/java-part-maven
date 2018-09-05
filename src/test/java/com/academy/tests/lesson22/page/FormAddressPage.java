package com.academy.tests.lesson22.page;

import com.academy.tests.lesson22.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAddressPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement addressField1;

    @FindBy(id = "address2")
    private WebElement addressField2;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement zipField;

    @FindBy(id = "id_country")
    private WebElement countrySelect;

    @FindBy(id = "phone")
    private WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "other")
    private WebElement additionalInformationField;

    @FindBy(id = "alias")
    private WebElement addressTitleField;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;

    public FormAddressPage(WebDriver driver) {
        super(driver);
    }

    public FormAddressPage modifyFirstName(String firstName) {
        inputTextField(firstNameField, firstName);
        return this;
    }

    public FormAddressPage modifyLastName(String lastName) {
        inputTextField(lastNameField, lastName);
        return this;
    }

    public FormAddressPage modifyCompany(String companyName) {
        inputTextField(companyField, companyName);
        return this;
    }

    public FormAddressPage modifyAddressLine1(String addressLine1) {
        inputTextField(addressField1, addressLine1);
        return this;
    }

    public FormAddressPage modifyAddressLine2(String addressLine2) {
        inputTextField(addressField2, addressLine2);
        return this;
    }

    public FormAddressPage modifyCity(String city) {
        inputTextField(cityField, city);
        return this;
    }

    public FormAddressPage modifyState(String state) {
        //new Select
        return this;
    }

    public FormAddressPage modifyZip(String zip) {
        inputTextField(zipField, zip);
        return this;
    }

    public FormAddressPage modifyCountry(String country) {
        //new Select
        return this;
    }

    public FormAddressPage modifyHomePhone(String homePhone) {
        inputTextField(homePhoneField, homePhone);
        return this;
    }

    public FormAddressPage modifyMobilePhone(String mobilePhone) {
        inputTextField(homePhoneField, mobilePhone);
        return this;
    }

    public FormAddressPage modifyAdditionalInformation(String additionalInformation) {
        inputTextField(additionalInformationField, additionalInformation);
        return this;
    }

    public FormAddressPage modifyAddressTitle(String addressTitle) {
        inputTextField(addressTitleField, addressTitle);
        return this;
    }

    public FormAddressPage clickSaveButton(){
        saveButton.click();
        return new FormAddressPage(driver);
    }












































}
