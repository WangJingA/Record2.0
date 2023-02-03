package com.example.dayrecords.Utils;

import java.util.regex.Pattern;

public class PassJudgeUtil {
    public static boolean judge(String password){
        if (password.length()>12||password.length()<6){
            return false;
        }
        String rule = "^(?![0-9]+$)(?![a-zA-Z]+$)(?![0-9a-zA-Z]+$)(?![0-9\\W]+$)(?![a-zA-Z\\W]+$)[0-9A-Za-z\\W]{6,12}$";
        boolean matches = Pattern.matches(rule, password);
        return matches;
    }
}
