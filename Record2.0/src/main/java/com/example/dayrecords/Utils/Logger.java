package com.example.dayrecords.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
    public static Logger logger(){
       return (Logger) log;
    }
}
