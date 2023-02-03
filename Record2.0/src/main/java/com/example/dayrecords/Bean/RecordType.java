package com.example.dayrecords.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * 日记类型表
 */
public class RecordType {
    private int id;
    private int recordType;
    private String recordName;
    private String recordDesc;
}
