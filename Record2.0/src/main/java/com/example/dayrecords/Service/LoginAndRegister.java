package com.example.dayrecords.Service;



import com.example.dayrecords.Bean.RecordUser;
import com.example.dayrecords.Utils.ResultDTO;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface LoginAndRegister {
    /**
     * 登录
     * @param user
     * @param session
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws MessagingException
     */
    public ResultDTO login(RecordUser user, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException, MessagingException;

    /**
     * 注册
     * @param user
     * @param session
     * @return
     */
    public ResultDTO register(RecordUser user, HttpSession session);

    /**
     * 验证码发送
     * @param session
     * @return
     */
    ResultDTO code(HttpSession session, String email) throws MessagingException;

    /**
     * 发送注册邮寄码
     * @return
     */
    ResultDTO sendMailCode(HttpSession session, String mailAddress) throws MessagingException;
}
