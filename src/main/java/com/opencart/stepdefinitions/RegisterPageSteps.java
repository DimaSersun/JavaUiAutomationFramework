package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManger;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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
        registerPage.clickOnContinueButton(driver);
    }
}
