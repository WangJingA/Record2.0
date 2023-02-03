package com.example.dayrecords.Utils;



import com.example.dayrecords.Enum.ResponseEnum;

import java.io.Serializable;

/**
 * 请求结果集合
 * @param <T>
 */
public class ResultDTO<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
  public static ResultDTO Success(){
      return new ResultDTO(ResponseEnum.FIND_SUCCESS.getCode(), ResponseEnum.FIND_SUCCESS.getMsg(),null);
  }
    public static ResultDTO Fail(){
        return new ResultDTO(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(),null);
    }
    public static ResultDTO SuccessResponseData(Object data){
        return new ResultDTO(ResponseEnum.FIND_SUCCESS.getCode(), ResponseEnum.FIND_SUCCESS.getMsg(),data);
    }
    public static ResultDTO elevotorSuccess(){
        return new ResultDTO(ResponseEnum.FIND_SUCCESS.getCode(), ResponseEnum.FIND_SUCCESS.getMsg(),null);
    }
    public static ResultDTO elevotorFail(){
        return new ResultDTO(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg(), null);
    }
    public static ResultDTO elevotorSuccessResponseData(Object data){
        return new ResultDTO(ResponseEnum.FIND_SUCCESS.getCode(), ResponseEnum.FIND_SUCCESS.getMsg(),data);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
