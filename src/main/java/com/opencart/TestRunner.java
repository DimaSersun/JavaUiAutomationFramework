package com.opencart;

import com.opencart.managers.DriverManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //Degine a driver object that will be used future actions.
        WebDriver driver = DriverManger.getInstance().getDriver();

        driver.get("https://www.opencart.com/");

        String curentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.google.com/");
        Thread.sleep(4000);

        driver.close();

        driver.switchTo().window(curentWindowName);
        Thread.sleep(4000);

        driver.get("https://diez.md/");

        driver.quit();

        System.out.println("The execution was finished");

    }

}
