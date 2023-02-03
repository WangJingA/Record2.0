package com.example.dayrecords.Dao;



import com.example.dayrecords.Bean.RecordRemind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordRemindDao {
    /**
     * 获取备忘信息
     * @param userId
     * @return
     */
    public List<RecordRemind> getRecordRemind(int userId);

    /**
     * 增加备忘录
     * @param recordRemind
     * @return
     */
    public boolean addRecordRemind(RecordRemind recordRemind);

    /**
     * 获取所有的备忘录信息
     * @return
     */
    public List<RecordRemind> getAllRemind();
}
