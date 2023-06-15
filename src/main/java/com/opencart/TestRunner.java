package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManger;
import com.opencart.managers.ScrollManger;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //Define a driver object that will be used future actions.
        WebDriver driver = DriverManger.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");

        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();

        WebElement registrBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registrBtn.click();

        String firstName = DataFakerManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);

        String lastName = DataFakerManager.getRandomName();
        System.out.println("The generated last name is: " + lastName);

        String email = DataFakerManager.getRandomEmail();
        System.out.println("The generated eMail name is: " + email);

        String password = DataFakerManager.getPassword(4, 20);
        System.out.println("The generated password name is: " + password);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInout = driver.findElement(By.id("input-email"));
        emailInout.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);
        Thread.sleep(1000);

        WebElement privacyToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManger.scrollToElement(driver, privacyToggle);
        privacyToggle.click();

        WebElement continueButotn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButotn.click();

        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(currentWindowName);

        driver.get("https://andreisecuqa.host/");

        driver.quit();

        System.out.println("The execution was finished");

    }

}
