package com.academy.tests.lesson11.login;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.validator.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormValidatorTests {

    //tests data

    private String[] validPasswords = {"1qweEtyuiq", "123Qwerty", "Azerty12!", "R421ghjk"};
    private String[][] invalidPasswords = {
            {"", "Empty Password"},
            {"12dW!", "Password is too short"},
            {"FgsasGFH", "Password must contain digit"},
            {"123gfhfjk", "Password must contain upper symbols"},
            {"WERET2ET1", "Password must contain lower symbols"}};
    private String existingEmail = "test@mail.ru";
    private String validEmail = "test@yahoo.com";
    private String invalidEmail = "@sad@sds@,.com";
    private String emptyString = "";
    private  String email = "test@mail.ru";

    private RegistrationValidator validator = new RegistrationValidator();

    RegistrationForm registrationForm = new RegistrationForm()
            .withFirstName("", "user")
            .withLastName("", "user")
            .withMail("", "test@test.ua")
            .withPassword("", "Azerty12!")
            .withConfirmPassword("", "Azerty12!");

    //tests
    @Test
    public void testFirstNameValidation() {

        registrationForm.withFirstName("First Name", emptyString);
        boolean isValid = validator.validate(registrationForm);
        Assert.assertFalse(isValid);
        String msgError = validator.getMsgError();
        System.out.println("test 1: " + msgError);
    }

    @Test
    public void testLastNameValidation() {

        registrationForm.withLastName("Last Name", emptyString);

        boolean isValid = validator.validate(registrationForm);

        Assert.assertFalse(isValid);
        String msgError = validator.getMsgError();
        System.err.println("test 2: " + msgError);
    }

    @Test
    public void testEmailValidation() {
        //valid email
        registrationForm.withMail("Email", email);
        boolean isValid =  validator.validate(registrationForm);
        Assert.assertTrue(isValid);

        //empty email

        boolean isValid1 = validator.validate(registrationForm);
        Assert.assertTrue(isValid1);
        String msgError = validator.getMsgError();
        System.err.println("test 3.1:" + msgError);

        //invalid email
        registrationForm.withMail("Email", invalidEmail);
        boolean isValid2 = validator.validate(registrationForm);
        Assert.assertFalse(isValid2);
        msgError = validator.getMsgError();
        System.err.println("test 3.2:" + msgError);
    }

    @Test
    public void testPasswordValidation() {

        //valid passwords
        for (int i = 0; i < validPasswords.length; i++) {
            registrationForm.withConfirmPassword("Password", validPasswords[i]);
            registrationForm.withPassword("Password", validPasswords[i]);
            boolean isValid = validator.validate(registrationForm);
            Assert.assertTrue(isValid);
        }

//        //invalid passwords
        for (int i = 0; i < invalidPasswords.length; i++) {
            for (int j = 0; j < invalidPasswords[i].length; j++) {

                //invalid passwords
                registrationForm.withPassword("Password", invalidPasswords[i][j]);
                boolean isValid = validator.validate(registrationForm);
                Assert.assertTrue(!isValid);
                String msgError = invalidPasswords[i][j] + "\t";
                System.out.print(msgError);
            }
            System.out.println();
        }

        //password mismatch
        registrationForm.withPassword("Password", "1qweEtyuiq");
        registrationForm.withConfirmPassword("Password", "1qweEtyui");
        boolean isValid = validator.validate(registrationForm);

        String msgError = validator.getMsgError();
        System.err.println(msgError);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testConfirmPasswordValidation(){


       //invalid passwords
        for (int i = 0; i < invalidPasswords.length; i++) {
            for (int j = 0; j < invalidPasswords[i].length; j++) {

                //invalid passwords
                registrationForm.withConfirmPassword("Confirm Password", invalidPasswords[i][j]);
                boolean isValid = validator.validate(registrationForm);
                Assert.assertTrue(!isValid);
                String msgError = invalidPasswords[i][j] + "\t";
                System.out.print(msgError);
            }
            System.out.println();
        }
    }

    @Test
    public void testExistenceUserValidatation(){

        registrationForm.withMail("Email", email);
        boolean isValid = validator.validate(registrationForm);

        if (email.equals(existingEmail)){

            String msgError = validator.getMsgError();
            System.err.println(msgError);
            System.out.println(isValid);
            Assert.assertFalse(isValid);

        }
        else
            Assert.assertTrue(isValid);
    }

}




