package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MyForm extends Main {

    @Test
    public static void MyTest() throws InterruptedException {

        //create driver
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String url = "https://demoqa.com";
        driver.get(url);


        WebElement form = driver.findElement(By.xpath("//div[@class='category-cards']/div[2]"));
        form.click();
        WebElement form2 = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li"));
        form2.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
        firstName.clear();
        firstName.sendKeys("Something");

        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
        lastName.clear();
        lastName.sendKeys("New");

        WebElement Email = driver.findElement(By.xpath("//*[@id='userEmail']"));
        Email.click();
        Email.sendKeys("qwert@test.com");

        WebElement genderRadioButton = driver.findElement(By.xpath("(//*[@id='genterWrapper']//label)[3]"));
        genderRadioButton.click();

        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id='userNumber']"));
        mobileNumber.click();
        mobileNumber.sendKeys("1234567890");

        WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
        dateOfBirth.click();
        WebElement selectYear = driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        Select year = new Select(selectYear);
        year.selectByValue("1990");
        WebElement selectDate = driver.findElement(By.xpath("(//div[@class='react-datepicker__month']//div[@role='option'])[15]"));
        selectDate.click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("Hindi");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.RETURN);

        WebElement moveToCheckbox = driver.findElement(By.id("state"));
        WebElement checkbox = driver.findElement(By.xpath("//label[@for = 'hobbies-checkbox-1']"));
        new Actions(driver).moveToElement(moveToCheckbox).perform();
        checkbox.click();
        driver.findElement(By.id("currentAddress")).sendKeys("Odesa, Ukraine");

        WebElement moveTostateCity = driver.findElement(By.id("stateCity-wrapper"));
        new Actions(driver).moveToElement(moveTostateCity).perform();



        WebElement advertising = driver.findElement(By.xpath("//div[@id='fixedban']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", advertising);
        WebElement advertising2 = driver.findElement(By.xpath("//body/div[@id='app']/footer[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", advertising2);


        WebElement selectState = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
        WebElement selectCity = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));

        new Actions(driver).click(selectState).sendKeys(Keys.RETURN).perform();
        new Actions(driver).click(selectCity).sendKeys(Keys.RETURN).perform();


        /* sleep(5000); */

        driver.findElement(By.id("userForm")).submit();
        assertEquals(driver.findElement(By.id("example-modal-sizes-title-lg")).getText(), "Thanks for submitting the form", "Different texts");

        driver.quit();
    }
}




