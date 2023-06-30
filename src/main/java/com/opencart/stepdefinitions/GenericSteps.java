package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManger.getInstance().getDriver();
    @Given("The {string} is accessed")
    public void theIsAccessed(String urlValue) {
        driver.get(urlValue);
        System.out.println("The "+ urlValue +"was accesed by the Driver:");
    }

    @Then("the following error message are displayed:")
    public void theFollowingErrorMessageAreDisplayed(List<String> errorMessagesList) throws InterruptedException {
        for (int i = 0; i < errorMessagesList.size(); i++){
            Thread.sleep(500);
            String elementXpath = "//*[contains(text(),'"+errorMessagesList.get(i)+"')]";
            WebElement errorMessageElement = driver.findElement(By.xpath(elementXpath));
            boolean isErrorMessageNumberIDisplayed = errorMessageElement.isDisplayed();
            Assertions.assertTrue(isErrorMessageNumberIDisplayed, "The error message" + errorMessagesList.get(i));
        }
    }

    @Then("the current url contains the following keyword: {string}")
    public void theCurrentUrlContainsTheFollowingKeyword(String keyword) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectedString = driver.getCurrentUrl().contains(keyword);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectedString, "The" + keyword + "is present within the url");
    }
}
