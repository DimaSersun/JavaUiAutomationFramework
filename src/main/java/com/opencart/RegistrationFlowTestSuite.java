package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManger;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachTestFromFirstClass(){
        WebDriver driver = DriverManger.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test number" + counter + "started");
    }
    @Test
    @DisplayName("The URL contains success keyword after registration with void data")
    public void registerFlowRedirectsTheUserToTheCorrectUrl() throws InterruptedException {

        homePage.navigateToRegisterPageFromHeaderMenu();

        Thread.sleep(2000);
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getPassword(4, 20);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        Thread.sleep(1000);
        registerPage.switchOnPrivacyToggle(driver);
        Thread.sleep(1000);
        registerPage.clickOnContinueButton();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accauntCreatePage = new AccountCreatedPage(driver);
        accauntCreatePage.logOutFromAccount();
        Thread.sleep(1000);

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("Test");
        String errorMessage = "the Url" + driver.getCurrentUrl() + "Does not contain succes keyword";
        Assertions.assertFalse(urlContainsTheCorrectKeywords, errorMessage);

    }
    @Test
    @DisplayName("The URL contains register keyword when privacy policy is not accepted")
    public void registerFlowIsBlockedByPrivacy() throws InterruptedException {

        homePage.navigateToRegisterPageFromHeaderMenu();

        Thread.sleep(2000);
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getPassword(4, 20);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        //Do not enable the privacy toggle
        //registerPage.switchOnPrivacyToggle(driver);
        Thread.sleep(1000);
        registerPage.clickOnContinueButton();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accauntCreatePage = new AccountCreatedPage(driver);
        accauntCreatePage.logOutFromAccount();
        Thread.sleep(1000);

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("Test");
        String errorMessage = "the Url" + driver.getCurrentUrl() + "Does not contain succes keyword";
        Assertions.assertFalse(urlContainsTheCorrectKeywords, errorMessage);

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("Register");
        Assertions.assertTrue(urlContainsRegisterKeyword, "The URL belongs to register page");
        DriverManger.getInstance().quitTheDriver();
    }
    @AfterEach
    public void executeThisMethodAfterEachTestCase(){
        DriverManger.getInstance().quitTheDriver();
        System.out.println("The test number" + counter + "finished");
    }
}