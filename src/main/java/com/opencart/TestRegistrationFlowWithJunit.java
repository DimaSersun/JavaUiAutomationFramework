package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManger;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {
    private WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeAll
    public static void beforAll(){
        System.out.println("This test is before all.");
    }

    @BeforeEach
    public void beforeEach(){
        driver = DriverManger.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
    }

    @AfterEach
    public void afterEach(){
        DriverManger.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("This text is after all.");
    }

    @Test
    @Order(1)
    @DisplayName("Register user test.")
    public void registerUserTest() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String fakeName = DataFakerManager.getRandomName();
        String fakeLastName = DataFakerManager.getRandomName();
        String fakeEmail = DataFakerManager.getRandomEmail();
        String fakePassword = DataFakerManager.getPassword(10,25);

        registerPage.fillInTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
        registerPage.switchOnPrivacyToggle(driver);
        registerPage.clickOnContinueButton(driver);

        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyword);
    }

    @Test
    @Order(2)
    @DisplayName("Register user test without privacy button.")
    public void registerUserWithoutLastNameTest() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String fakeName = DataFakerManager.getRandomName();
        String fakeLastName = "";
        String fakeEmail = DataFakerManager.getRandomEmail();
        String fakePassword = DataFakerManager.getPassword(10,25);

        registerPage.fillInTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
        registerPage.switchOnPrivacyToggle(driver);
        registerPage.clickOnContinueButton(driver);


        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertFalse(urlContainsSuccessKeyword);
    }
}