package com.example.dayrecords.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * 邮件发送
 */
@Slf4j
@Component
public class SendMailUtil {
    @Autowired
    JavaMailSender javaMailSender;
    public void simpleSend(Map sendInfo) throws MessagingException {
        String moduleName = "simpleSend";
        long currTime = System.currentTimeMillis();
        log.info(String.format(">>>>>>进入%s执行方法",moduleName));
        if(sendInfo.containsKey("attachment")){
            String attachName = null;
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            if (sendInfo.containsKey("setTo")){
                mimeMessageHelper.setTo(sendInfo.get("setTo").toString());
            }
            mimeMessage.setFrom("心情日记<1670373895@qq.com>");

            if(sendInfo.containsKey("text")){
                mimeMessageHelper.setText(sendInfo.get("text").toString());
            }
            if(sendInfo.containsKey("subject")){
                mimeMessageHelper.setSubject(sendInfo.get("subject").toString());
            }
            if (sendInfo.containsKey("attachName")){
                attachName = sendInfo.get("attachName").toString();
            }else {
                attachName = "附件";
            }
            if (sendInfo.containsKey("attachment")){
                mimeMessageHelper.addAttachment(attachName,new File(sendInfo.get("attachment").toString()));
            }
            javaMailSender.send(mimeMessage);
        }else {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            if (sendInfo.containsKey("setTo")){
                simpleMailMessage.setTo(sendInfo.get("setTo").toString());
            }

                simpleMailMessage.setFrom("心情日记<1670373895@qq.com>");

            if (sendInfo.containsKey("sendDate")){
                simpleMailMessage.setSentDate((Date) sendInfo.get("sendDate"));
            }
            if(sendInfo.containsKey("text")){
                simpleMailMessage.setText(sendInfo.get("text").toString());
            }
            if(sendInfo.containsKey("subject")){
                simpleMailMessage.setSubject(sendInfo.get("subject").toString());
            }
                javaMailSender.send(simpleMailMessage);
        }
        log.info(String.format(">>>>>>结束%s执行方法耗时%s",moduleName,System.currentTimeMillis()-currTime));
    }
}
