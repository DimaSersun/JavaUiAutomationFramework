package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManger;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {

    WebDriver driver = DriverManger.getInstance().getDriver();
    @Then("the new url contains {string} keyword")
    public void theNewUrlContainsKeyword(String collectedStringValue) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectedString = driver.getCurrentUrl().contains(collectedStringValue);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectedString, "The" + collectedStringValue + "is present within the url");
    }
}
