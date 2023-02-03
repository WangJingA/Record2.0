package com.example.dayrecords.Service.Impl;

import com.example.dayrecords.Dao.RecordImgDao;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.RecordImgService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class RecordImgServiceImpl implements RecordImgService {
    @Autowired
    RecordImgDao imgDao;
    /**
     * 获取系统推荐图片
     * @return
     */
    @Override
    public ResultDTO getRecomandImg() {
        String moduleName = "RecordImgService-getRecomandImg";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s]",moduleName));
        Map<String,Object> recommandImg = imgDao.getRecommandImg();
        log.info(String.format(">>>执行处理方法[%s],共耗时：[%s],返回数据：[%s]",moduleName,
                System.currentTimeMillis()-startTime,recommandImg));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),recommandImg);
    }
}
