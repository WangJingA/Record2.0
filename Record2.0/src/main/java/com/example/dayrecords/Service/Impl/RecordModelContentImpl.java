package com.example.dayrecords.Service.Impl;


import com.example.dayrecords.Bean.RecordModelContent;
import com.example.dayrecords.Dao.RecordModelContentDao;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.RecordModelContentService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecordModelContentImpl implements RecordModelContentService {
    @Autowired
    RecordModelContentDao recordModelContentDao;

    /**
     * 获取所有的日记模板内容
     * @return
     */
    @Override
    public ResultDTO getRecordModelContent() {
        String moduleName = "Service-getRecordModelContent";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));
        List<RecordModelContent> modelContent = recordModelContentDao.getModelContent();
        log.info(String.format(">>>数据[%s]",modelContent));
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),modelContent);
    }

    /**
     * 依靠id获取日记模板内容
     * @param id
     * @return
     */
    @Override
    public ResultDTO getRecordModelContentById(int id) {
        String moduleName = "Service-getRecordModelContentById";
        long startTime = System.currentTimeMillis();
        RecordModelContent modelContent = recordModelContentDao.getModelContentById(id);
        log.info(String.format(">>>数据[%s]",modelContent));
        log.info(String.format(">>>执行处理方法[%s]共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),modelContent);
    }
}
