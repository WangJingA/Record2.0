package com.example.dayrecords.Service.Impl;

import cn.hutool.core.date.StopWatch;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.FileService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

@Slf4j
@Service
public class FileServiceImpl implements FileService {
    Scanner scanner = new Scanner(System.in);
    /**
     * 文件上传
     * @return
     */
    @Override
    public ResultDTO FileUpload(MultipartFile file) throws IOException {
        String moduleName = "FileServiceImpl-FileUpload";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>进入处理方法[%s],处理参数[%s]",moduleName,file));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("service");
        //目录
        String fileUrl = "/main/resource/static/files";
        File FileAddr = new File(fileUrl);
        //获取初始名字
        String originalFilename = file.getOriginalFilename();
        String newName = originalFilename.substring(0,originalFilename.indexOf("."))+scanner.nextInt(5)+
                originalFilename.substring(originalFilename.lastIndexOf("."));
        //转换文件地址
        file.transferTo(new File(FileAddr.getAbsolutePath() + "/" + newName));
        log.info(String.format(">>>执行处理方法共耗时:[%s]",System.currentTimeMillis()-startTime));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMsg(),"上传文件成功！");
    }

    /**
     * 文件解析
     * @return
     */
    @Override
    public void FileResolve(HttpServletResponse response,String fileUrl) throws IOException {
        String moduleName = "FileServiceImpl-FileResolve";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],处理参数为:[%s]",moduleName,fileUrl));
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            outputStream = response.getOutputStream();
            File newFile = new File(fileUrl);
            inputStream = new FileInputStream(newFile);
            String[] urlSplit = fileUrl.split("/");
            String file = urlSplit[urlSplit.length-1];
            String[] fileSplit = file.split("[.]");
            System.out.println(urlSplit[urlSplit.length-1]);
            String fileType = fileSplit[fileSplit.length-1];
            //包含图片类型
            response.reset();
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Content-Disposition", "inline;fileName=" + java.net.URLEncoder.encode(newFile.getName(), "UTF-8"));
            response.setHeader("Content-Length",""+file.length());
            if ("jpg,gif,png,jepg".contains(fileType)) {
                response.setContentType("image/" + fileType);
            }
            if ("pdf,docx".contains(fileType)) {
                response.setContentType("application/" + fileType+";charset=UTF-8");
            } else {
                response.setContentType("multipart/form-data");
            }
            //读取文件流
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                //写入输出流
                outputStream.write(buffer, 0, len);
                System.out.println(new String(buffer));
            }
            response.setStatus(200);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
            e.getMessage();
        }
        finally {
            //关闭流
            inputStream.close();
            outputStream.close();
        }
    }
}
