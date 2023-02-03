package com.example.dayrecords.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encode {
    public final static String encode(String originText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //转换密文的字符数组
        char [] btInput = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        //获取传入的加密信息的utf-8字符
        byte[] bytes = originText.getBytes("UTF-8");
        //获取MD5摘要,获取的是加密信息编码的
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        //获取密文
        byte[] digest = messageDigest.digest();
        //创建32位字符串数组
        char [] result = new char[digest.length*2];
        //将密文转换成16进制的字符串形式
        int k = 0;
        for (int i =0;i<digest.length;i++){
            //获取每一位密文
            byte c = digest[i];
            //将每一位密文转换成btInput十六进制的字符
            result[k++] = btInput[c >>> 4 & 0xf];
            //增加一位字符
            result[k++] = btInput[c & 0xf];
        }
        //将32位字符数组转换成字符串输出
        return new String(result);
    }
    /**
     * @description : 加密字符串，普通不加盐(16进制，256位)
     * @param text
     * @return
     */
    public static String  getString(String text){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //获取字符串字节数组
            byte[] bytes = text.getBytes();
            //计算字符串加密摘要
            byte[] digest = md5.digest(bytes);
            //转换成16进制字符串
            String md5String = bytesToDex(bytes);
            return md5String;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @description : 将字节数组转换成16进制字符串
     * @param bytes
     * @return
     */
    public static String bytesToDex(byte [] bytes){

        StringBuffer md5Buffer = new StringBuffer();
        int digestLength;
        for (int i =0 ; i<bytes.length; i++){
            digestLength = bytes[i];
            if (digestLength < 0){
                digestLength += 256;
            }
            if (digestLength < 16){
                md5Buffer.append("0");
            }
            md5Buffer.append(Integer.toHexString(digestLength));
        }
        //大写输出
        return md5Buffer.toString().toUpperCase();
    }

    /**
     *	 将16进制字符串转换成字节数组
     * @param hex
     * @return
     */
    public static byte[] String16ToBytes(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++){
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte)Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }
}
