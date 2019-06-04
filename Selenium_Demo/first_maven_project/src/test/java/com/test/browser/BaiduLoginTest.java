package com.test.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaiduLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void baiduLoginTest() throws InterruptedException {
        driver.get("http;//www.baidu.com");
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);
        WebElement userTextFiled = driver.findElement(By.name("userName"));
        //清空输入框
        userTextFiled.clear();
        userTextFiled.sendKeys("xxxxxxxx");
        driver.findElement(By.name("password")).sendKeys("xxxxxx");
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        Thread.sleep(10000);
        //定位用户名标签，并获取标签文本
        String userName = driver.findElement(By.className("user-name")).getText();
        System.out.println("获取到的用户名：" + userName);
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}













































