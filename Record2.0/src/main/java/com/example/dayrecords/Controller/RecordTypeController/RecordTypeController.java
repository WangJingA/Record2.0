package com.example.dayrecords.Controller.RecordTypeController;


import com.example.dayrecords.Bean.RecordType;
import com.example.dayrecords.Service.RecordTypeService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("record")
public class RecordTypeController {
    @Autowired
    RecordTypeService recordTypeService;
    @RequestMapping("/getRecordType")
    @ResponseBody
    public ResultDTO getRecordType(){
        String moduleName = "RecordTypeController-getRecordType";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法",moduleName));
        List<RecordType> recordType = recordTypeService.getRecordType();
        log.info(String.format(">>>执行%s方法耗时%s",moduleName,System.currentTimeMillis()-startTime));
        return ResultDTO.elevotorSuccessResponseData(recordType);
    }
}
