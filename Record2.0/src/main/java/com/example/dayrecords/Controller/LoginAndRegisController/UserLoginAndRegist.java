package com.example.dayrecords.Controller.LoginAndRegisController;



import com.example.dayrecords.Bean.RecordUser;
import com.example.dayrecords.Service.LoginAndRegister;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Controller
@RequestMapping("record")
public class UserLoginAndRegist {
    @Autowired
    LoginAndRegister loginAndRegister;
    @PostMapping("/login")
    @ResponseBody
    public ResultDTO login(RecordUser user, HttpSession session) throws MessagingException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String moduleName = "RecordTypeController-getRecordType";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法",moduleName));
        ResultDTO login = loginAndRegister.login(user, session);
        log.info(String.format(">>>执行%s方法耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return login;
    }

    @PostMapping("/regis")
    @ResponseBody
    public ResultDTO register(RecordUser user, HttpSession session){
        String moduleName = "RecordTypeController-getRecordType";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法",moduleName));
        ResultDTO register = loginAndRegister.register(user, session);
        log.info(String.format(">>>执行%s方法耗时%s",moduleName,System.currentTimeMillis()-startTime));
        return register;
    }
    @PostMapping("/code")
    @ResponseBody
    public ResultDTO judgeCode(@RequestParam("email") String email, HttpSession session) throws MessagingException {
        String moduleName = "RecordTypeController-getRecordType";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法,参数%s",moduleName,email));
        ResultDTO code = loginAndRegister.code(session,email);
        log.info(String.format(">>>执行%s方法耗时%s",moduleName,System.currentTimeMillis()-startTime));
        return code;
    }
}
