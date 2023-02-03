package com.example.dayrecords.Service;

import com.example.dayrecords.Utils.ResultDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件service
 */
public interface FileService {
    /**
     * 文件上传
     * @return
     */
    public ResultDTO FileUpload(MultipartFile file) throws IOException;

    /**
     * 文件解析
     * @return
     */
    public void FileResolve(HttpServletResponse response,String fileUrl) throws IOException;
}
