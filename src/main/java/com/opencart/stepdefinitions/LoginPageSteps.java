package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManger;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManger.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @And("the following data is entered into the login form:")
    public void theFollowingDataIsEnteredIntoTheLoginForm(List<String> userDetailList) {
        String emailValue = userDetailList.get(0);
        String passwordValue = userDetailList.get(1);
        loginPage.fillInTheLoginForm(emailValue, passwordValue);
    }

    @When("loginButton is clicked")
    public void loginButtonIsClicked() {
        loginPage.clickOnLoginBtn();
    }
}
