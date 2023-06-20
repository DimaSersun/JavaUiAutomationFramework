package com.opencart.pageobjects;

import com.opencart.managers.ScrollManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id ="input-firstname")
    private WebElement firstNameImput;

    @FindBy(id ="input-lastName")
    private WebElement lastNameImput;

    @FindBy(id ="input-email")
    private WebElement emailImput;

    @FindBy(id ="input-password")
    private WebElement passwordImput;

    @FindBy(css ="//input[@name='agree']")
    private WebElement privacyToggle;

    @FindBy(xpath ="//button[normalize-space()='Continue']")
    private WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password){
        firstNameImput.sendKeys(firstName);
        System.out.println("The entered first name is: " + firstName);

        lastNameImput.sendKeys(lastName);
        System.out.println("The entered last name is: " + lastName);

        emailImput.sendKeys(email);
        System.out.println("The entered email is: " + email);

        passwordImput.sendKeys(password);
        System.out.println("The entered password is: " + password);

    }

    public  void switchOnPrivacyToggle(WebDriver driver) throws InterruptedException {
        ScrollManger.scrollToElement(driver, privacyToggle);
        privacyToggle.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
