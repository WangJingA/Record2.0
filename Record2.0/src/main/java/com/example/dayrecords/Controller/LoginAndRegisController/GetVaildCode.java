package com.example.dayrecords.Controller.LoginAndRegisController;

import com.example.dayrecords.Configuration.VaildateCode;
import com.example.dayrecords.Service.LoginAndRegister;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/login")
public class GetVaildCode {
    @Autowired
    VaildateCode code;
    @Autowired
    LoginAndRegister loginAndRegister;
    /**
     * 获取登录验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("getCheckCode/{date}")
    public void getCheckCode(HttpServletRequest request, HttpServletResponse response, @PathVariable("date") String date) throws IOException {
        long startTime = System.currentTimeMillis();
        String moduleName = "getCheckCodeController";
        log.info(String.format(">>>"));
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        HttpSession session = request.getSession();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("code",text);
        log.info(String.format(">>>>验证码[%s]",text));
        log.info(String.format(">>>>执行处理方法%s共耗时%s",moduleName,System.currentTimeMillis()-startTime));
        VaildateCode.output(image, response.getOutputStream());
    }
    @GetMapping("sendRegisCode")
    @ResponseBody
    public ResultDTO getRegisCode(HttpSession session, @RequestParam String email) throws MessagingException {
        long startTime = System.currentTimeMillis();
        String module = "getRegisCode-Mapping";
        log.info(String.format(">>>进入%s处理方法",module));
        log.info(String.format(">>>参数[%s]",email));
        ResultDTO resultDTO = loginAndRegister.sendMailCode(session, email);
        log.info(String.format(">>>执行处理方法%s一共耗时%s毫秒",module,System.currentTimeMillis()-startTime));
        return new ResultDTO(resultDTO.getCode(), resultDTO.getMsg(), resultDTO.getData());
    }
}
