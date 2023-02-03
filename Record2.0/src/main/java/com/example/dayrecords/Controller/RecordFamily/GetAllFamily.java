package com.example.dayrecords.Controller.RecordFamily;



import com.example.dayrecords.Service.RecordFamilyService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/family")
public class GetAllFamily {
    @Autowired
    RecordFamilyService recordFamilyService;
    @GetMapping("getFamily")
    @ResponseBody
    public ResultDTO getFamily(){
        String moduleName = "getFamily-controller";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>>进入%s处理方法",moduleName));
        ResultDTO recordFamily = recordFamilyService.getRecordFamily();
        log.info(String.format(">>>返回数据[%s]",recordFamily));
        log.info(String.format(">>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordFamily;
    }
}
