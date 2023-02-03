package com.example.dayrecords.Service.Impl;


import com.alibaba.fastjson.JSONArray;
import com.example.dayrecords.Bean.RecordContent;
import com.example.dayrecords.Dao.HistoryEvent;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.RecordHistoryService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@Slf4j
@Service
public class RecordHistoryServiceImpl implements RecordHistoryService {
    @Autowired
    HistoryEvent historyEvent;

    /**
     * 我的历史的今天
     * @param userId
     * @return
     */
    @Override
    public ResultDTO getMyHistory(int userId) {
        String moduleName = "RecordHistoryServiceImpl-getMyHistory";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数[%s]",moduleName,userId));
        List<Map> result = new JSONArray();
        List<RecordContent> myHistory = historyEvent.getMyHistory(userId);
        //当前的月份和日期
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(month+"-"+dayOfMonth);
        //时间对应处理
        if(myHistory != null && !myHistory.isEmpty()){
            for (RecordContent  history : myHistory) {
                String recordDate = history.getRecordDate();
                String recordMonth = recordDate.split("-")[1].toString();
                String recordDay= recordDate.split("-")[2].toString();
                System.out.println(recordMonth+"-"+recordDay);
                if ((Integer.parseInt(recordMonth) == month)&&(Integer.parseInt(recordDay) == dayOfMonth)){
                    Map<String,Object> info = new HashMap<String,Object>();
                    info.put("id",history.getRecordId());
                    info.put("label",history.getRecordTitle());
                    result.add(info);
                }
            }
        }
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒,处理结果[%s]",
                moduleName,System.currentTimeMillis()-startTime,result));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),result);
    }

    /**
     * 爬虫获取历史的今天
     * @return
     */
    @Override
    public ResultDTO getHistory() {
        String moduleName = "RecordHistoryServiceImpl-getHistory";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));

        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return null;
    }
}
