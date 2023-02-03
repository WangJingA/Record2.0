package com.example.dayrecords.Controller.HistoryEvent;

import com.example.dayrecords.Service.RecordHistoryService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/history")
public class HistoryWSDate {
    @Autowired
    RecordHistoryService historyService;
    /**
     * 获取我的历史的今天的事件
     * @return
     */
    @GetMapping("/myHistory")
    @ResponseBody
    public ResultDTO myHistory(@RequestParam int userId){
        String moduleName = "HistoryWSDate-myHistory";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数为：[%s]",moduleName,userId));
        ResultDTO history = historyService.getMyHistory(userId);
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒,执行 结果[%s]",
                moduleName,System.currentTimeMillis()-startTime,history));
        return history;
    }

    /**
     * 获取历史的今天
     * @return
     */
    @GetMapping("/history")
    @ResponseBody
    public ResultDTO history(){
        return null;
    }
}
