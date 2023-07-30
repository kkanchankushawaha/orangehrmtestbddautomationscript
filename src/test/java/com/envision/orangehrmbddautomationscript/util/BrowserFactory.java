package com.envision.orangehrmbddautomationscript.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class BrowserFactory {


    private static WebDriver driver = null;

    public static WebDriver getBrowser(String browserName){

        switch (browserName.toLowerCase().intern()){

            case "chrome":
                BrowserFactory.driver = new ChromeDriver();
                break;

            case "edge":
                BrowserFactory.driver = new EdgeDriver();
                break;

            case "firefox":
                BrowserFactory.driver = new FirefoxDriver();
                break;
        }

       return BrowserFactory.driver;

    }
    public static void closeCurrentWindow(){
        BrowserFactory.driver.close();
    }

    public static void closeAllWindows(){
        BrowserFactory.driver.quit();
    }

    public static void openUrl(String url){
        BrowserFactory.driver.get(url);
        BrowserFactory.driver.manage().window().maximize();
        BrowserFactory.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
