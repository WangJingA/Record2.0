package com.example.dayrecords.Dao;


import com.example.dayrecords.Bean.RecordUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserLoginAndRegisterDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    RecordUser getUserByLoginInfo(RecordUser user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean addUser(RecordUser user);

    /**
     * 注册时查找用户是否已经存在
     *
     * @param userMail
     * @return
     */
    RecordUser searchUser(String userMail);
}
