package com.example.dayrecords.Enum;

/**
 * 枚举所有的情况
 */
public enum ResponseEnum {
    FIND_SUCCESS(200,"查询成功！"),
    ELEVOTOR_SUCCESS(200,"操作成功！"),
    ADD_SUCCESS(200,"增加成功！"),
    FIND_ERROR(202,"查找失败！"),
    ADD_ERROR(202,"该用户已经存在"),
    FAIL(202,"失败"),
    SUCCESS(200,"成功"),
    ELEVOTOR_ERROR(202,"操作失败！")
    ;
    int code;
    String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
