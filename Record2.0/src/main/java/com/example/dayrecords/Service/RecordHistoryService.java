package com.example.dayrecords.Service;

import com.example.dayrecords.Utils.ResultDTO;

public interface RecordHistoryService {
    /**
     * 获取对应今日我的历史
     * @param userId
     * @return
     */
    public ResultDTO getMyHistory(int userId);

    /**
     * 历史的今天
     * @return
     */
    public ResultDTO getHistory();
}
