package com.example.dayrecords.Service.Impl;


import com.example.dayrecords.Bean.RecordType;
import com.example.dayrecords.Dao.RecordTypeListDao;
import com.example.dayrecords.Service.RecordTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecordTypeServiceImpl implements RecordTypeService {
    @Autowired
    RecordTypeListDao recordTypeListDao;
    @Override
    public List<RecordType> getRecordType() {
        String moduleName = "getRecordType";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s",moduleName));
        List<RecordType> recordType = recordTypeListDao.getRecordType();
        log.info(String.format(">>>执行%s方法耗时%s",moduleName,System.currentTimeMillis()-startTime));
        return recordType;
    }
}
