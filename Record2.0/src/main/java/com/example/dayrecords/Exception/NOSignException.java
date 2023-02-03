package com.example.dayrecords.Exception;

/**
 * 未进行数字签名异常
 */
public class NOSignException extends RuntimeException{
 public  NOSignException(String message){
     super(message);
 }
}
