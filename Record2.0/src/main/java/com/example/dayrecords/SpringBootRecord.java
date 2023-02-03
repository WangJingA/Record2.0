package com.example.dayrecords;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

@SpringBootApplication
@MapperScan("com.example.dayrecords.Dao")
public class SpringBootRecord {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRecord.class,args);
    }

}
