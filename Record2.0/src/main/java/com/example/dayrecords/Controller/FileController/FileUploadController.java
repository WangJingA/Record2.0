package com.example.dayrecords.Controller.FileController;

import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.FileService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    FileService fileService;
    @GetMapping("fileUpload")
    public ResultDTO FileUpload(@RequestParam("file") MultipartFile file){
        String moduleName = "FileUploadController-FileUpload";
        log.info(String.format(">>>进入请求方法[%s],请求参数为:[%s]",moduleName,file));
        try{
            ResultDTO resultDTO = fileService.FileUpload(file);
            return resultDTO;
        }catch (Exception e){
            e.printStackTrace();
            log.info(String.format(">>>请求方法[%s]失败",moduleName));
            return new ResultDTO(ResponseEnum.FAIL.getCode(),
                    ResponseEnum.FAIL.getMsg(),"上传失败");
        }
    }
}
