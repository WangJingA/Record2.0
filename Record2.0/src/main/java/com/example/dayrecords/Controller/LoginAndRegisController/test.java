package com.example.dayrecords.Controller.LoginAndRegisController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

public class test {
    @Autowired
    StopWatch get;
public void testStop(){
    get.start("测试");
    System.out.println("打印");
    get.stop();
    System.out.println(get.shortSummary());
}
    public static void main(String[] args) {
        test test = new test();
        test.testStop();
    }
}
