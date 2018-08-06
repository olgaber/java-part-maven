package com.academy.tests.lesson11.login;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.validator.*;
import com.academy.lesson11.login.FormValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationFormValidatorTests {

    //tests data

    private String[] validPasswords = {"1qweEtyuiq", "123Qwerty", "Azerty12!", "R421ghjk"};
    private String[] invalidPasswords = {"", "12dW!", "FgsasGFH", "123gfhfjk", "WERET2ET1"};
    private String existingEmail = "test@mail.ru";
    private String validEmail = "test@yahoo.com";
    private String invalidEmail = "@sad@sds@,.com";
    private String emptyString = "";


    private RegistrationValidator validator = new RegistrationValidator();

    RegistrationForm registrationForm = new RegistrationForm()
            .withFirstName("", "user")
            .withLastName("", "user")
            .withMail("", "test@test.ua")
            .withPassword("", "Azerty12!")
            .withConfirmPassword("", "Azerty12!");

    //tests
    @Test
    public void testFirstNameValidation() throws FormValidationException{
        registrationForm.withFirstName("First Name", emptyString);
        boolean isValid = validator.validate(registrationForm);
        if (!isValid){
            Assert.assertFalse(isValid);
            //         String msgError = validator.getMsgError();
            //         System.out.println(msgError);
            //       throw new FormValidationException();
        }
    }

    @Test
    public void testLastNameValidation() throws FormValidationException{
        registrationForm.withLastName("Last Name", emptyString);
        boolean isValid = validator.validate(registrationForm);
        if (!isValid){

//            String msgError = validator.getMsgError();
//            System.err.println(msgError);
            Assert.assertFalse(isValid);
//            throw new NameValidationException();
        }
    }

    @Test
    public void testEmailValidation(String mail) {
        //valid email
        final Pattern pattern = Pattern.compile("^[\\w%+\\-]+@[A-Za-z\\-]+\\.[A-Za-z]{2,4}$");
        final Matcher matcher = pattern.matcher(mail);
        Assert.assertTrue(matcher.find());

        //empty email
        registrationForm.withMail("Email", validEmail);
        boolean isValid = validator.validate(registrationForm);
        Assert.assertTrue(isValid);

        //invalid email
        registrationForm.withMail("Email", invalidEmail);
        isValid = validator.validate(registrationForm);
        Assert.assertFalse(isValid);

    }

    @Test
    public void testPasswordValidation() throws FormValidationException {

        //valid passwords
        for (int i = 0; i < validPasswords.length; i++) {
            registrationForm.withConfirmPassword("Password", validPasswords[i]);
            registrationForm.withPassword("Password", validPasswords[i]);
            boolean isValid = validator.validate(registrationForm);
            if (!isValid){

                String msgError = validator.getMsgError();
                System.err.println(msgError);
                throw new FormValidationException();
            }
            Assert.assertTrue(isValid);
        }
        //invalid passwords
        for (int i = 0; i < invalidPasswords.length; i++) {

            //invalid passwords
            registrationForm.withPassword("Password", invalidPasswords[i]);
            boolean isValid = validator.validate(registrationForm);
            if (!isValid){
//                String msgError = validator.getMsgError();
//                System.err.println(msgError);
                Assert.assertFalse(isValid);
//                throw new FormValidationException();
            }

        }
        //password mismatch
        registrationForm.withPassword("Password", "1qweEtyuiq");
        registrationForm.withConfirmPassword("Password", "1qweEtyui");
        boolean isValid = validator.validate(registrationForm);
        if (!isValid){

//                String msgError = validator.getMsgError();
//                System.err.println(msgError);
            Assert.assertFalse(isValid);
//                throw new FormValidationException();
        }
    }

    @Test
    public void testConfirmPasswordValidation() throws FormValidationException {

        //valid passwords
        for (int i = 1; i < validPasswords.length; i++) {

            registrationForm.withPassword("Password", validPasswords[i]);
            registrationForm.withConfirmPassword("Password", validPasswords[i]);
            boolean isValid = validator.validate(registrationForm);
            if (!isValid){

                String msgError = validator.getMsgError();
                System.err.println(msgError);
                throw new FormValidationException();
            }
            Assert.assertTrue(isValid);
        }
        //invalid passwords
        for (int i = 0; i < invalidPasswords.length; i++) {

            //invalid passwords
            registrationForm.withConfirmPassword("Password", invalidPasswords[i]);
            boolean isValid = validator.validate(registrationForm);
            if (!isValid){

//                String msgError = validator.getMsgError();
//                System.err.println(msgError);
                Assert.assertFalse(isValid);
//                throw new FormValidationException();
            }
        }
    }

    @Test
    public void testExistenceUserValidatation()throws FormValidationException{

        registrationForm.withMail("Email", validEmail);
        boolean isValid = validator.validate(registrationForm);

        if (validEmail.equals(existingEmail)){

            String msgError = validator.getMsgError();//???????
            System.err.println(msgError);
            throw new FormValidationException();

        }
        else
            Assert.assertTrue(isValid);
    }
}






