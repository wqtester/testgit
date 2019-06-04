package com.test.browser;

import org.junit.Test;

/**
 * 图片和字符串互转(通过base64编码)单元测试类
 */
public class Base64Picture {

    /**
     * 图片转换为base64编码字符串单元测试
     */
    @Test
    public void getImageStrTest() {
        String imgStr = Base64Decode.GetImageStr("E://testPicture//index.jpg");
        System.out.println(imgStr);
    }

    /**
     * base64编码字符串转换为图片单元测试
     */
    @Test
    public void generateImageTest() {
        String imgStr = "$captcha";
        Base64Decode.GenerateImage(imgStr, "E://testPicture//b.jpg");
    }

//    /**
//     * 图片和字符串互转(通过base64编码)单元测试
//     */
//    @Test
//    public void generateStrAndImageTest() {
//        String imgStr = Base64Decode.GetImageStr("E://testPicture//a.jpg");
//        System.out.println(imgStr);
//        Base64Decode.GenerateImage(imgStr, "E://testPicture//c.jpg");
//    }

}