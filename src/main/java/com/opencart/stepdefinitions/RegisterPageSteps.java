package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManger;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManger.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);
    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String fakeName = DataFakerManager.getRandomName();
        String fakeLastName = DataFakerManager.getRandomName();
        String fakeEmail = DataFakerManager.getRandomEmail();
        String fakePassword = DataFakerManager.getPassword(10,25);

        registerPage.fillInTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
    }

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() throws InterruptedException {
        registerPage.switchOnPrivacyToggle(driver);
    }

    @And("continueButton is clicked")
    public void continuebuttonIsClicked() throws InterruptedException {
        Thread.sleep(400);
        registerPage.clickOnContinueButton(driver);
    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String>userDetailsMap) {
        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = DataFakerManager.getRandomName();
        }
        String lastNameValue = userDetailsMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")){
            lastNameValue = DataFakerManager.getRandomName();
        }
        String emailValue = userDetailsMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")){
            emailValue = DataFakerManager.getRandomEmail();
        }
        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")){
            passwordValue = DataFakerManager.getPassword(6,12);
        }
        registerPage.fillInTheRegisterForm(firstNameValue,lastNameValue,emailValue,passwordValue);
    }
}
