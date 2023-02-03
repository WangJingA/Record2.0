package com.example.dayrecords.Service;



import com.example.dayrecords.Bean.RecordRemind;
import com.example.dayrecords.Utils.ResultDTO;

public interface RecordRemindService {
    /**
     * 获取备忘录
     * @param id
     * @return
     */
    public ResultDTO getRecordRemind(int id);

    /**
     * 添加备忘录
     * @param recordRemind
     * @return
     */
    public ResultDTO addRecordRemind(RecordRemind recordRemind);
}
