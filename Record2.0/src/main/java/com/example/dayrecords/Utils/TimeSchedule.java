package com.example.dayrecords.Utils;

import com.example.dayrecords.Bean.RecordRemind;
import com.example.dayrecords.Dao.RecordRemindDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.*;


/**
 * 定时执行
 */
@Configuration
public class TimeSchedule extends Thread{
    @Autowired
    RecordRemindDao recordRemindDao;
    @Autowired
    SendMailUtil sendMailUtil;
    public void run(){
        List<RecordRemind> allRemind = recordRemindDao.getAllRemind();
        if(allRemind != null) {
            //定时任务
            for (RecordRemind remind : allRemind) {
                Date recordRemindDate = remind.getRecordRemindDate();
                long remindDate = recordRemindDate.getTime();
                Date createDate = remind.getRecordCreateDate();
                long remindCreate = createDate.getTime();
                int sub = (int) (remindCreate-remindDate);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            //定时发送邮件备忘提醒
                            Map mail = new HashMap<String,Object>();
                            mail.put("setTo",remind.getRecordUserMail());
                            mail.put("from","心情日记");
                            mail.put("subject","登录心情日记");
                            mail.put("text",remind.getRecordRemindContent());
                            mail.put("sendDate",new Date());
                            sendMailUtil.simpleSend(mail);
                            System.out.println("发送邮件成功");
                            System.out.println("进入定时器");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },sub, 0);
            }
        }
    }
}
