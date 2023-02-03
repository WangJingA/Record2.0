package com.example.dayrecords.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SetMailCode {
    public static String code(){
      String module = "SetMailCode-utils";
      long startTime = System.currentTimeMillis();
      String mailCode = "";
      //获取6位数随机邮件发送码
        int mount = 6;
        for (int i = 0; i < mount; i++) {
            int random = (int)(Math.random()*10);
            System.out.println(random);
            mailCode += random;
        }
        return mailCode;
    }
}
