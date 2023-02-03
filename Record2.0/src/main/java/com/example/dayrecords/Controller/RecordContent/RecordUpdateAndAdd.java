package com.example.dayrecords.Controller.RecordContent;

import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/update")
public class RecordUpdateAndAdd {
    @PostMapping("updateRecord")
    public ResultDTO updateRecord(Map<String,Object> record){
        String moduleName = "RecordUpdateAndAdd-updateRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法%s",moduleName));

        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",
                moduleName,System.currentTimeMillis()-startTime));
        return null;
    }
}
