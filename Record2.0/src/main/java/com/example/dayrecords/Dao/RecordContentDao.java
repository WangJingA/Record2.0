package com.example.dayrecords.Dao;


import com.example.dayrecords.Bean.RecordContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordContentDao {
    /**
     * 获取用户日记内容
     * @return
     */
    public List<String> getContent(int userId);
    /**
     * 获取用户日记篇数,分类显示篇数
     */
    public int getPage(RecordContent recordContent);

    /**
     * 添加日记
     * @param recordContent
     * @return
     */
    public boolean addRecord(RecordContent recordContent);

    /**
     * 修改日记
     * @param recordContent
     * @return
     */
    public boolean updateRecord(RecordContent recordContent);

    /**
     * 分页获取日记数据
     * @param userId
     * @param page
     * @return
     */
    public List<RecordContent> getRecordWithPage(@Param("userId") int userId, @Param("page") int page);

    /**
     * 获取用户的所有的日记篇数，日记分页显示的总数
     * @param userId
     * @return
     */
    public int getTotalPage(@Param("userId") int userId);

    /**
     * 依靠日记id获取日记
     * @param recordId
     * @return
     */
    public Map<String,Object> getRecordById(@Param("recordId") int recordId);
}
