package com.example.dayrecords.MD5;

import com.example.dayrecords.Exception.NOSignException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CheckSign {
    public final static boolean check(String check,String sign){
        if (check.isEmpty()){
            new NOSignException("签名失败");
        }
        try {
            String encode = MD5Encode.encode(check);
            if (sign.equals(encode)){
                return true;
            }
            else {
                new NOSignException("签名失败");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
