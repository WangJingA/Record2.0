package com.example.dayrecords.Utils;

import com.example.dayrecords.Exception.OrdinaryException;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * 校验注册的密码是否符合规范，大写字母开头，包含数字，小写字母，长都不超过8位
 */
@Slf4j
public class PassworkDist {
    public static boolean judgePass(String originPass){
        boolean judge = false;
        //长度不能超过8
        if(originPass.length()>16){
            new OrdinaryException("密码长度超出限制范围");
            return judge;
        }
        //大写字母，数字，小写字母
        String model1 = "[A-Z]*[0-9]*[a-z]*";
        //大写字母，小写字母，数字
        String model2 = "[A-Z]*[a-z]*[0-9]*";
        log.info(String.format(">>>%s,匹配的正确度%s",model1,Pattern.matches(model1,originPass)));
        log.info(String.format(">>>%s,匹配的正确度%s",model2,Pattern.matches(model2,originPass)));
        return Pattern.matches(model1,originPass) || Pattern.matches(model2,originPass) ? true:judge;
    }
}
