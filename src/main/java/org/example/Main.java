package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {



    public static WebDriver main(String[] args) {
        final String path = String.format("%s/bin/chromedriver.exe", System.getProperty("user.dir"));
        System.setProperty("webDriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }


}

//}






