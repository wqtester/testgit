package com.test.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpsLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openOpsTest() throws InterruptedException {
        driver.get("http://test.ops.gs.9188.com");
        driver.findElement(By.xpath("/html//div[@id='tab-password']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='pane-password']/form[@class='el-form']/div[1]//input[@type='text']")).sendKeys("test11");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='pane-password']/form[@class='el-form']/div[2]//input[@type='password']")).sendKeys("123123");
        driver.findElement(By.xpath("//div[@id='pane-password']/form[@class='el-form']//div[@class='el-input']/input[@type='text']")).sendKeys("youyu_auth");
        driver.findElement(By.xpath("//div[@id='pane-password']/form[@class='el-form']//button[@type='button']")).click();
        Thread.sleep(3000);
        String userName =driver.findElement(By.className("user-name")).getText();
        System.out.println("获取到的用户名：" + userName);
       //获取当前页面的句柄
        String winHandleBefore = driver.getWindowHandle();
        // for 循环判断 获取到的handles是否等于当前页面  如果不等于就将权限赋予给跳转的页面
        for(String winHandle : driver.getWindowHandles()) {
            //与第一个页面内的句柄比较  当句柄不予第一个相等时 就把权限赋予给了新窗口 只适用于两个窗口的情况
            if(winHandle.equals(winHandleBefore)) {
                continue;
            }
            //给要跳转的新界面进行权限赋予  要传入新页面的句柄
            driver.switchTo().window(winHandle);
            break;
        }
       driver.switchTo().frame("app");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/article/section/aside/div/ul/li[2]/div/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/article/section/aside/div/ul/li[2]/ul/div/div[2]/li/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/article/section/section/article/div/div[1]/div[1]/div[1]/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/article/section/section/article/div/div/div[2]/form/div[1]/div/div/input")).sendKeys("测试机房01");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/article/section/section/article/div/div/div[2]/form/div[2]/div/div[1]/input")).sendKeys("test");
        WebElement selectContract = driver.findElement(By.xpath("/html/body/div[1]/article/section/section/article/div/div/div[2]/form/div[3]/div/div/div[1]/input"));
        Thread.sleep(3000);
        Select select = new Select(selectContract);
        Thread.sleep(2000);
        select.selectByVisibleText("测试合同6");
        Thread.sleep(2000);
        select.deselectByIndex(1);
        Thread.sleep(2000);
        select.selectByValue("测试合同1");
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}

