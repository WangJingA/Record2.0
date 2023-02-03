package com.example.dayrecords.Controller.RecordRemind;



import com.example.dayrecords.Bean.RecordRemind;
import com.example.dayrecords.Service.RecordRemindService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/remind")
public class RecordRemindController {
    @Autowired
    RecordRemindService recordRemindService;
    @GetMapping("recordRemind")
    @ResponseBody
    public ResultDTO getRecordRemind(@RequestParam int userId){
        String moduleName = "RecordRemindController-getRecordRemind";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));
        ResultDTO recordRemind = recordRemindService.getRecordRemind(userId);
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return recordRemind;
    }
    @PostMapping("addRecordRemind")
    @ResponseBody
    public ResultDTO addRecordRemind(RecordRemind recordRemind){
        String moduleName = "RecordRemindController-addRecordRemind";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数[%s]",moduleName,recordRemind));
        ResultDTO resultDTO = recordRemindService.addRecordRemind(recordRemind);
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]毫秒",moduleName,System.currentTimeMillis()-startTime));
        return resultDTO;
    }
}
