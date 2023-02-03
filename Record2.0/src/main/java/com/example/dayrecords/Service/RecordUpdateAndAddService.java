package com.example.dayrecords.Service;

import com.example.dayrecords.Bean.RecordContent;
import com.example.dayrecords.Utils.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public interface RecordUpdateAndAddService {
    /**
     * @description:更新日记
     * @param recordContent 对应的日记
     * @return
     */
     ResultDTO updateRecord(RecordContent recordContent);

    /**
     * @description:添加日记
     * @param recordContent
     * @return
     */
     ResultDTO addRecord(RecordContent recordContent);
}
