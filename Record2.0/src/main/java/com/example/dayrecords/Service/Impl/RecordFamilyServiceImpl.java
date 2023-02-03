package com.example.dayrecords.Service.Impl;



import com.alibaba.fastjson.JSONArray;
import com.example.dayrecords.Bean.RecordFamily;
import com.example.dayrecords.Dao.RecordFamilyDao;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.RecordFamilyService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RecordFamilyServiceImpl implements RecordFamilyService {
    @Autowired
    RecordFamilyDao recordFamilyDao;

    /**
     * 获取日记记录字体
     * @return
     */
    @Override
    public ResultDTO getRecordFamily() {
        String moduleName = "getRecordFamily-service";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法",moduleName));
        List<RecordFamily> recordFamily = recordFamilyDao.getRecordFamily();
        List<Map> result = new JSONArray();
        if (recordFamily != null){
            for (RecordFamily family : recordFamily){
                Map<String,Object> fontFamily = new HashMap<String,Object>();
                fontFamily.put("value",family.getId());
                fontFamily.put("label",family.getRecordFamily());
                result.add(fontFamily);
            }
        }
        log.info(String.format(">>>处理方法返回[%s]",recordFamily));
        log.info(String.format(">>>>执行处理方法%s耗时%s毫秒",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),result);
    }
}
