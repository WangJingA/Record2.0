package com.example.dayrecords.Service;

import com.example.dayrecords.Bean.RecordContent;
import com.example.dayrecords.Utils.ResultDTO;

/**
 * 日记内容
 */
public interface RecordContentService {
    /**
     * 获取用户日记首页日记数据
     * @param userId
     * @return
     */
    public ResultDTO getRecordInfo(int userId);

    /**
     * 获取用户日记
     * @param userId
     * @return
     */
    public ResultDTO getRecord(int userId, int page);

    /**
     * 添加日记
     * @param recordContent
     * @return
     */
    public ResultDTO addRecord(RecordContent recordContent);

    /**
     * 获取分页日记
     * @param userId
     * @param page
     * @return
     */
    public ResultDTO getPageRecord(int userId, int page);

    /**
     * 依靠日记id获取日记信息
     * @param recordId
     * @return
     */
    public ResultDTO getRecordById(int recordId);
}
