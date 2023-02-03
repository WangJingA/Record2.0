package com.example.dayrecords.Service.Impl;


import cn.hutool.extra.tokenizer.TokenizerUtil;
import com.example.dayrecords.Bean.RecordUser;
import com.example.dayrecords.Dao.UserLoginAndRegisterDao;
import com.example.dayrecords.Enum.Constances;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.MD5.MD5Encode;
import com.example.dayrecords.Service.LoginAndRegister;
import com.example.dayrecords.Utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginAndRegisterImpl implements LoginAndRegister {
    @Autowired
    UserLoginAndRegisterDao loginAndRegisterDao;
    @Autowired
    SendMailUtil sendMailUtil;
    @Override
    public ResultDTO login(RecordUser user, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException, MessagingException {
        String moduleName = "LoginAndRegisterImpl-login";
        long startTime = System.currentTimeMillis();
        Map<String,String> tokenMap = new HashMap<String,String>();
        log.info(String.format(">>>>>进入%s执行方法",moduleName));
        log.info(String.format(">>>>>用户登录信息："+user));
        //登录次数
        int loginCount = 0;
        String userPass = user.getUserPass();
        //获取session验证码
        if (session.getAttribute("code") != null){
            String  code = session.getAttribute("code").toString();
            System.out.println("code:"+code);
            System.out.println("userCode:"+user.getCode());
            if (!code.equalsIgnoreCase(user.getCode())){
                tokenMap.put("msg","验证码错误");
                return new ResultDTO(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg(),tokenMap);
            }
        }
        //获取登录次数统计，失败三次叠加五分钟登录
        if(session.getAttribute("loginCount") != null){
            int count = Integer.parseInt(session.getAttribute("loginCount").toString());
            if (count > 3){

            }
        }
        //存储密码进行二次加密
        userPass = MD5Encode.getString(userPass);
        user.setUserPass(userPass);
        System.out.println(userPass);
        RecordUser userByLoginInfo = loginAndRegisterDao.getUserByLoginInfo(user);
        System.out.println(userByLoginInfo);
        if (userByLoginInfo != null){
            //认证成功，获取token
            tokenMap.put("userMail",user.getUserMail());
            tokenMap.put("userid",String.valueOf(userByLoginInfo.getUserId()));
            String token = JWTUtils.getToken(tokenMap);
            tokenMap.clear();
            tokenMap.put("token",token);
            tokenMap.put("msg", "登录成功-"+userByLoginInfo.getUserId());
            //发送登录成功邮件
            Map mail = new HashMap<String,Object>();
            mail.put("setTo","3381864766@qq.com");
            mail.put("from","心情日记");
            mail.put("subject","登录心情日记");
            mail.put("text",userByLoginInfo.getUserName()+"在"+new Date()+"登录心情日记成功");
            mail.put("sendDate",new Date());
//            sendMailUtil.simpleSend(mail);
            log.info(String.format(">>>>>执行处理方法%s耗时%s",moduleName,System.currentTimeMillis()-startTime));
            log.info(String.format(">>>>>发送登录邮件"));
            return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),
                    tokenMap);
        }
        tokenMap.put("msg","用户不存在");
        //登录失败次数记录，失败三次禁止五分钟叠加登录
        loginCount ++;
        session.setAttribute("loginCount",loginCount);
        log.info(String.format(">>>>>执行处理方法%s耗时%s",
                                moduleName,System.currentTimeMillis()-startTime));
         return new ResultDTO(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(),
                tokenMap);
    }

    @Override
    public ResultDTO register(RecordUser user, HttpSession session) {
        long startTime = System.currentTimeMillis();
        String module = "register-service";
        Map<String,String> resultMap = new HashMap<String,String>();
        log.info(">>>[%s]进入[%s]处理方法","用户",module);
        System.out.println(user);
        if(user != null){
            //检查邮件注册码是否正确
            if (!session.getAttribute("code").equals(user.getCode())){
                resultMap.put("msg","邮件注册码不正确");
                return new ResultDTO(ResponseEnum.FAIL.getCode(),
                                     ResponseEnum.FAIL.getMsg(),resultMap);
            }
            //依靠注册邮箱检索是否已经存在用户
            RecordUser recordUser = loginAndRegisterDao.searchUser(user.getUserMail());
            if (recordUser != null){
                resultMap.put("msg","该用户已经存在");
                return new ResultDTO(ResponseEnum.FAIL.getCode(),
                                     ResponseEnum.FAIL.getMsg(),resultMap);
            }
            //用户密码校验
            String decrypt = AESUtils.decrypt(user.getUserPass(), Constances.DECRYPTKEY);
            if(!PassJudgeUtil.judge(decrypt)){
                resultMap.put("msg","密码必须包含数字、特殊符号 、大小写字母");
                return new ResultDTO(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(),
                        resultMap);
            }
            //注册用户
            //注册用户密码加密
            String userPass = user.getUserPass();
            String encode = MD5Encode.getString(userPass);
            user.setUserPass(encode);
            user.setUserLoginGrant(0);
            user.setUserLoginUpdate(new Date());
            user.setUserLoginResolveTime(0);
            boolean register = loginAndRegisterDao.addUser(user);

            if (!register){
                resultMap.put("msg","注册失败！");
                return new ResultDTO(ResponseEnum.FAIL.getCode(),
                                     ResponseEnum.FAIL.getMsg(),resultMap);
            }
        }
        resultMap.put("msg","注册成功！");
        return new ResultDTO(ResponseEnum.ADD_SUCCESS.getCode(),
                             ResponseEnum.ADD_SUCCESS.getMsg(),resultMap);
    }

    @Override
    public ResultDTO code(HttpSession session, String email) throws MessagingException {
        String moduleName = "code";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>>进入%s执行方法",moduleName));
        if ("".equals(email)){
            throw new AddressException("邮箱地址不存在");
        }
        String randomNum = RandomNum.getRandomNum();
        //发送登录成功邮件
        Map mail = new HashMap<String,Object>();
        mail.put("setTo",email);
        mail.put("from","1670373895@qq.com");
        mail.put("subject","验证码");
        mail.put("text",randomNum);
        mail.put("sendDate",new Date());
        sendMailUtil.simpleSend(mail);
        //将验证码保存到session
        session.setAttribute("code",randomNum);
        log.info(String.format(">>>>>执行处理方法%s耗时%s",
                 moduleName,System.currentTimeMillis()-startTime));
        return ResultDTO.elevotorSuccess();
    }

    @Override
    public ResultDTO sendMailCode(HttpSession session, String mailAddress) throws MessagingException {
        String module = "sendMailCode-service";
        long startTime = System.currentTimeMillis();
        //获取随机6位数邮件码
        String code = SetMailCode.code();
        //发送邮件
        Map<String,Object> mail = new HashMap<String,Object>();
        mail.put("setTo",mailAddress);
        mail.put("from","1670373895@qq.com");
        mail.put("subject","验证码");
        mail.put("text",code);
        mail.put("sendDate",new Date());
        sendMailUtil.simpleSend(mail);
        session.setAttribute("mailCode",code);
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),
                             ResponseEnum.SUCCESS.getMsg(),"发送注册码成功");
    }
}
