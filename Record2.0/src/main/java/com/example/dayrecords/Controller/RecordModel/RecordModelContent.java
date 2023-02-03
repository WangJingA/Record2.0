package com.example.dayrecords.Controller.RecordModel;

import com.example.dayrecords.Service.RecordModelContentService;
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
@RequestMapping("/model")
public class RecordModelContent {
    @Autowired
    RecordModelContentService modelContentService;
    @GetMapping("getAllModelContent")
    @ResponseBody
    public ResultDTO getRecordModelContent(){
        String moduleName = "controller-getRecordModelContent";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入[%s]处理方法",moduleName));
        ResultDTO recordModelContent = modelContentService.getRecordModelContent();
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordModelContent;
    }

    @GetMapping("getModelContent")
    @ResponseBody
    public ResultDTO getRecordModelContentById(@RequestParam int id){
        String moduleName = "controller-getRecordModelContentById";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入[%s]处理方法",moduleName));
        ResultDTO recordModelContent = modelContentService.getRecordModelContentById(id);
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordModelContent;
    }
}
