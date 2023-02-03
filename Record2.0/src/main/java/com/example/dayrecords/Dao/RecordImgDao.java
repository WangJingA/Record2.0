package com.example.dayrecords.Dao;

import com.example.dayrecords.Bean.RecordRecommandImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RecordImgDao {
    public Map<String,Object> getRecommandImg();
}
