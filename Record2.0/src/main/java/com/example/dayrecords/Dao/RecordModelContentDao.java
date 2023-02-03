package com.example.dayrecords.Dao;



import com.example.dayrecords.Bean.RecordModelContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordModelContentDao {
    /**
     * 获取日记模板内容
     * @return
     */
    public List<RecordModelContent> getModelContent();

    /**
     * 依靠id获取日记模板内容
     * @param id
     * @return
     */
    public RecordModelContent getModelContentById(int id);
}
