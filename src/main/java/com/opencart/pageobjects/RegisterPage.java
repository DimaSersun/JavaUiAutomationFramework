package com.opencart.pageobjects;

import com.opencart.managers.ScrollManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyToggle;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        System.out.println("The entered first name is: " + firstName);

        lastNameInput.sendKeys(lastName);
        System.out.println("The entered last name is: " + lastName);

        emailInput.sendKeys(email);
        System.out.println("The entered email is: " + email);

        passwordInput.sendKeys(password);
        System.out.println("The entered password is: " + password);

    }

    public  void switchOnPrivacyToggle(WebDriver driver) throws InterruptedException {
        ScrollManger.scrollToElement(driver, privacyToggle);
        privacyToggle.click();
    }

    public void clickOnContinueButton(WebDriver driver) throws InterruptedException {
        ScrollManger.scrollToElement(driver, submitButton);
        submitButton.click();
    }
}
