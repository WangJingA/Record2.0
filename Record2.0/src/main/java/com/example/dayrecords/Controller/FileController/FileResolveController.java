package com.example.dayrecords.Controller.FileController;

import com.example.dayrecords.Service.FileService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileResolveController {
    @Autowired
    FileService fileService;
    @GetMapping("fileResolve")
    public void FileResolve (HttpServletResponse response,@RequestParam String fileUrl) throws IOException {
         fileService.FileResolve(response,fileUrl);
    }
}
