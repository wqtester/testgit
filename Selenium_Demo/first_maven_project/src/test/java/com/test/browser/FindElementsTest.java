package com.test.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
    }

    //通过id定位百度搜索文本框
    @Test
    public void byIDTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }

    //通过name定位搜索文本框
    @Test
    public void byNameTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    //通过class属性定位搜索文本框
    @Test
    public void byClassTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("quickdelete"));
    }

    //通过linkText定位搜索文本框
    @Test
    public void byLinkTestTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("新闻"));
    }

    //通过partiallinkText定位搜索文本框
    @Test
    public void bypartialLinkTestTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("hao"));
    }

    //通过tagname定位搜索文本框
    @Test
    public void byTagNameTest() {
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }

    //通过xpath定位搜索文本框
    @Test
    public void byXpathTest() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath(".//*[@id='u1']/a[4]"));
        System.out.println(e1.getText());
    }

    /**
     * 打开百度页面
     * 通过xpath 百度一下按钮
     */
    @Test
    public void byXpath02() {
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }

    }

    /**
     * 打开百度页面
     * 通过cssSelector 百度图片
     */
    @Test
    public void byCSS() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.cssSelector("#lg>img"));
    }

    //定位 新闻 链接文本，并点击
    @Test
    public void clickTest(){
        driver.get("https://www.baidu.com");
        WebElement newsLink = driver.findElement(By.xpath("//div[@id='head']/div/div[3]/a[@name='tj_trnews']"));
        newsLink.click();
    }

    @Test
    public  void sendKeysTest(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        //定位百度一下按钮，并点击
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void clearTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位搜索框
        WebElement searchTextFiled = driver.findElement(By.id("kw"));
        // 输入 "selenium"
        searchTextFiled.sendKeys("selenium");
        // 为了看到效果，等待3S
        Thread.sleep(3000);
        // 清空文本框
        searchTextFiled.clear();
    }

    // 获取右上角所有的文本并输出
    @Test
    public void getTextTest() {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位首页右上角文本,多个元素用findElements()
        List<WebElement> listText = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (WebElement element : listText) {
            // 获取元素文本
            String text = element.getText();
            System.out.println(text);
        }
    }

    @Test
    public void getTitleTest(){
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    //获取元素属性值：getAttribute("元素属性名")
    @Test
    public void getAttributeTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        //定位用户名文本框元素，并获取该元素placeholder的属性值
        String placeholderValue = driver.findElement(By.id("TANGRAM__PSP_10__userName")).getAttribute("placeholder");
        System.out.println(placeholderValue);
    }

    @Test
    public void getOpsAttributeTest() throws InterruptedException {
        driver.get("http://test.ops.gs.9188.com/");
        driver.findElement(By.linkText("密码登陆")).click();
        Thread.sleep(3000);
        //定位用户名文本框元素，并获取该元素placeholder的属性值
        String placeholderValue = driver.findElement(By.id("TANGRAM__PSP_10__userName")).getAttribute("placeholder");
        System.out.println(placeholderValue);
    }

    //提交表单 submit()
    @Test
    public void submitTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        // 定位用户名文本框,不做任何操作，直接提交表单
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).submit();
    }

    @Test
    public void getOpsTextTest() {
        // 打开OPS登录页
        driver.get("http://test.ops.gs.9188.com");
        // 定位“彩亿科技OPS系统”文本,多个元素用findElements()
        List<WebElement> listText = driver.findElements(By.xpath("//div[@id='app']//section[@class='login-body']//h1[@class='desc-line1']"));
        for (WebElement element : listText) {
            // 获取元素文本
            String text = element.getText();
            System.out.println(text);
        }
    }

    @AfterMethod
    public void colsedBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
