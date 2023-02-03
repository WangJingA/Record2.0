package com.example.dayrecords.Utils;



public class RandomNum {
    public static String  getRandomNum(){
        String random = "";
        //随机生成六位数字符串
        for(int i =0;i<5;i++){
            int num = (int) (Math.random()*10);
            random += num;
        }
        return random;
    }
}
