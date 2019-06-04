package com.test.browser;

import org.testng.annotations.*;

public class TestNGDemo01 {

    @Test
    public void test2() {
        System.out.println("test test2");
    }

    @Test
    public void test1(){
        System.out.println("test test1");
    }

    @Test
    public void test3(){
        System.out.println("test test3");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("test beforeClass");
    }
    @AfterClass
    public void aferClass() {
        System.out.println("test aferClass");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("test beforeTest");
    }
    @AfterTest
    public void aferTest() {
        System.out.println("test aferTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("test BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("test AfterMethod");
    }
}
