package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManger {
    private static String webDriverType = "Chrome";
    private static DriverManger instance;
    private WebDriver driver;

    private DriverManger(){
        switch (webDriverType.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver was initiated: ");
                break;
            case "FIREFIX":
                driver = new FirefoxDriver();
                System.out.println("The Firefix Driver was initiated: ");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated: ");
                break;
            default:
                System.out.println("Ther is not defined such a driver: ");

        }
    }

    public static DriverManger getInstance(){
        if (instance == null){
            instance = new DriverManger();
        }
        return instance;
    }

    public WebDriver getDriver(){
        if (driver == null){
            DriverManger.getInstance();
        }
        return  driver;
    }

}
