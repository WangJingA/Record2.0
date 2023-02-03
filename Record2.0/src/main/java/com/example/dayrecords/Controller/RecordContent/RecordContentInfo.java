package com.example.dayrecords.Controller.RecordContent;

import com.example.dayrecords.Service.RecordContentService;
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
@RequestMapping("/content")
public class RecordContentInfo {
    @Autowired
    RecordContentService recordContentService;

    /**
     * 获取日记首页数据信息
     * @param userId
     * @return
     */
    @GetMapping("getRecordContent")
    @ResponseBody
    public ResultDTO getRecordContent(@RequestParam("userId") int userId){
        String moduleName = "RecordContentInfo-getRecordContent";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        ResultDTO recordContent = recordContentService.getRecordInfo(userId);
        log.info(String.format(">>>返回数据[%s]",recordContent));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordContent;
    }
    @GetMapping("getRecord")
    @ResponseBody
    public ResultDTO getRecord(@RequestParam int userId, int page){
        String moduleName = "RecordContentInfo-getRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        ResultDTO record = recordContentService.getRecord(userId,page);
        log.info(String.format(">>>返回数据[%s]",record));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return record;
    }

    /**
     * 获取分页日记
     * @param userId
     * @param page
     * @return
     */
    @GetMapping("getPageRecord")
    @ResponseBody
    public ResultDTO getPageRecord(@RequestParam int userId, int page){
        String moduleName = "RecordContentInfo-getPageRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        ResultDTO record = recordContentService.getPageRecord(userId,page);
        log.info(String.format(">>>返回数据[%s]",record));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return record;
    }

    /**
     * 删除日记，添加到回收站
     * @param recordId
     * @param
     * @return
     */
    @GetMapping("delRecord")
    @ResponseBody
    public ResultDTO delRecord(@RequestParam int recordId){
        String moduleName = "RecordContentInfo-delRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));

        log.info(String.format(">>>返回数据[%s]",null));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return null;
    }

    /**
     * 依靠日记id获取日记
     * @param recordId
     * @return
     */
    @GetMapping("getRecordById")
    @ResponseBody
    public ResultDTO getRecordById(@RequestParam int recordId){
        String moduleName = "RecordContentInfo-getRecordById";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        ResultDTO recordById = recordContentService.getRecordById(recordId);
        log.info(String.format(">>>返回数据[%s]",null));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordById;
    }
}
