package com.example.dayrecords.Controller.ImgController;

import com.example.dayrecords.Service.RecordImgService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/img")
public class RecommanImg {
    @Autowired
    RecordImgService imgService;
    @GetMapping("getRecommandImg")
    @ResponseBody
    public ResultDTO getRecommand(){
        String moduleName = "ReCommanImg-getRecommand";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));
        ResultDTO recomandImg = imgService.getRecomandImg();
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return recomandImg;
    }
}
