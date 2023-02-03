package com.example.dayrecords.Dao;


import com.example.dayrecords.Bean.RecordType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordTypeListDao {
    public List<RecordType> getRecordType();
}
