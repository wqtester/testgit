package com.test.browser;

import net.sourceforge.lept4j.util.LoadLibs;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Base64ImgOcr {
    public static String GetData(String imageFile) {
        File file = new File(imageFile);
        Tesseract instance = new Tesseract();
        //设置tess配置的路径 classpath目录下
        File tessDataFolder = LoadLibs.extractNativeResources("tessdata");
        //用英文识别库，较为准确   instance.setLanguage("chi_sim");//中文库识别中文
        instance.setLanguage("eng");
        //设置tessdata路径
        instance.setDatapath(tessDataFolder.getAbsolutePath());

        try {
            String result = (String) instance.doOCR(new File(imageFile));
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return imageFile;
    }
}
