package com.test.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser_Test {
    public static void main(String[] args) {
        openChrome();
    }

    private static void openChrome() {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
    }
}
