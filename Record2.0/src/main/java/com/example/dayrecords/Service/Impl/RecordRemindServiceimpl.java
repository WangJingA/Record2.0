package com.example.dayrecords.Service.Impl;

import com.example.dayrecords.Bean.RecordRemind;
import com.example.dayrecords.Dao.RecordRemindDao;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Exception.OrdinaryException;
import com.example.dayrecords.Service.RecordRemindService;
import com.example.dayrecords.Utils.ResultDTO;
import com.example.dayrecords.Utils.TimeSchedule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RecordRemindServiceimpl implements RecordRemindService {
    @Autowired
    TimeSchedule timeSchedule;
    @Autowired
    RecordRemindDao recordRemindDao;
    @Override
    public ResultDTO getRecordRemind(int userId) {
        String moduleName = "RecordRemindServiceimpl-getRecordRemind";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数[%s]",moduleName,userId));
        if(StringUtils.isBlank(Integer.toString(userId))){
            throw new OrdinaryException("关键参数[userId]不能为空");
        }
        List<RecordRemind> recordRemind = recordRemindDao.getRecordRemind(userId);
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),recordRemind);
    }

    @Override
    public ResultDTO addRecordRemind(RecordRemind recordRemind) {
        String moduleName = "RecordRemindServiceimpl-addRecordRemind";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数[%s]",moduleName,recordRemind));
        if(recordRemind == null){
            throw new OrdinaryException("关键参数[userId]不能为空");
        }
        recordRemind.setRecordCreateDate(new Date());
        if (recordRemind.getRecordRemindDate()  == null || recordRemind.getRecordRemindDate().equals("")){
            return  new ResultDTO(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(),"没有备忘提醒时间");
        }
        boolean add = recordRemindDao.addRecordRemind(recordRemind);
        if (add){
            //定时发送邮件
            timeSchedule.start();
            return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),"增加备忘录成功");
        }
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(),"增加备忘录失败");
    }
}
