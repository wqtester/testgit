package com.test.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsDemo {
    WebDriver driver;
    @BeforeMethod
    public void openAndClosedBrowser() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void getTest() throws InterruptedException {

        // 最大化
        driver.manage().window().maximize();
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL：" + url);
/*        driver.navigate().to("https://www.sogou.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();*/
    }

    @AfterMethod
    public void cloaedChrom() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
