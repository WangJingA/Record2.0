package com.example.dayrecords.Dao;


import com.example.dayrecords.Bean.RecordFamily;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordFamilyDao {
    /**
     * 获取字体类型
     * @return
     */
    public List<RecordFamily> getRecordFamily();
}
