package com.example.dayrecords;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.dayrecords.MD5.MD5Encode;
import com.example.dayrecords.Utils.JWTUtils;
import com.example.dayrecords.Utils.TimeSchedule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.TimerTask;
@SpringBootTest
public class Timer {
    @Autowired
    StopWatch stopWatch;

    @Test
    public void test(){
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("定时开始");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }
    @Test
    public void testStopWatch(){
        String string = MD5Encode.getString("9p6IWTWlqVGf/DwfQ16/zw==");
        System.out.println(string);
        DecodedJWT verify = JWTUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTWFpbCI6IjE2NzAzNzM4OTVAcXEuY29tIiwiZXhwIjoxNjc1NDEyMDY0LCJ1c2VyaWQiOiIxMiJ9.ShFn5v4vfcBj8N1gSzC7ZpSkV4o4P8xuvb9O2yI5aH4");
        System.out.println(verify.toString());
    }

}
