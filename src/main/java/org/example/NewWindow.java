package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewWindow {

    @Test
    public static void MyTest2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String url = "https://demoqa.com";
        driver.get(url);

        WebElement form = driver.findElement(By.xpath("//div[@class='category-cards']/div[3]"));
        form.click();
        WebElement form2 = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li"));
        form2.click();
        driver.findElement(By.id("tabButton")).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(driver.findElement(By.id("sampleHeading")).getText(), "This is a sample page", "Different texts");
        driver.switchTo().window(tabs.get(0));
        driver.quit();
    }
}
