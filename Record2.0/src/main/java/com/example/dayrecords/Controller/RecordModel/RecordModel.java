package com.example.dayrecords.Controller.RecordModel;

import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/model")
public class RecordModel {
    @GetMapping("getRecordModel")
    public ResultDTO getRecordModel(){
        String moduleName = "RecordModel-getRecordModel";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return null;
    }
}
