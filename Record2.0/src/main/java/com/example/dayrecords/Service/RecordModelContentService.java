package com.example.dayrecords.Service;

import com.example.dayrecords.Utils.ResultDTO;

public interface RecordModelContentService {
    /**
     * 获取日记模板内容
     * @return
     */
    public ResultDTO getRecordModelContent();

    /**
     * 依靠id获取日记模板内容
     * @param id
     * @return
     */
    public ResultDTO getRecordModelContentById(int id);
}
