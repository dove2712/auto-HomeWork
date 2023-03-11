package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertNotEquals;

public class sMySlider {

    @Test
    public static void MyTest3() throws InterruptedException {
        //create driver

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String url = "https://demoqa.com";
        driver.get(url);

        WebElement form = driver.findElement(By.xpath("//div[@class='category-cards']/div[4]"));
        form.click();



        WebElement advertising = driver.findElement(By.xpath("//div[@id='fixedban']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", advertising);

        WebElement advertising2 = driver.findElement(By.xpath("//body/div[@id='app']/footer[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", advertising2);

        WebElement form2 = driver.findElement(By.xpath("(//div[@class='element-list collapse show']//li)[4]"));
        form2.click();

        WebElement slider = driver.findElement(By.xpath("//span[@class='range-slider__wrap']/input"));
        String startValue = slider.getAttribute("value");
        sleep(500);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 50, 0).build().perform();
        String endValue = slider.getAttribute("value");
        assertNotEquals(startValue, endValue);


        driver.quit();
    }
}
