package com.test.browser;

import java.io.*;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片和字符串互转(通过base64编码)
 * <p>
 *     1、将图片转换成base64字符串
 *     2、将base64字符串转换成图片
 * </p>
 * @author delphear
 * @version Id: Base64ToImage.java, v 0.1 2019/5/23 10:52 delphear Exp $$
 */
public class Base64Decode {

    /**
     *1、将图片转换成base64字符串
     * @param sourcePath 源文件路径名称
     * @return 源文件转换的字符串
     */
    public static String GetImageStr(String sourcePath) {
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(sourcePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            System.out.println("文件转换错误");
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
     * 2、将base64字符串转换成图片
     * @param imgStr  base64字符串
     * @param targetPath 生成的目标图片
     * @return 是否转换成功 ture:成功 false：失败
     */
    public static boolean GenerateImage(String imgStr, String targetPath) {
        //图像数据为空
        if (imgStr == null || targetPath == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    //调整异常数据
                    b[i] += 256;
                }
            }
            //新生成的图片
            OutputStream out = new FileOutputStream(targetPath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}