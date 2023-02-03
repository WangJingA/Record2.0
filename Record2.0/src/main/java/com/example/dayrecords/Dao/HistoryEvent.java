package com.example.dayrecords.Dao;



import com.example.dayrecords.Bean.RecordContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryEvent {
    /**
     * 获取相同今天我的历史
     * @param userId
     * @return
     */
    public List<RecordContent> getMyHistory(int userId);
}
