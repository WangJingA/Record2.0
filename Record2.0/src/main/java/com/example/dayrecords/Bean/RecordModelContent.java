package com.example.dayrecords.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordModelContent {
    private int recordModelId;
    private String recordModelName;
    private String recordModelContent;
    private String recordImg;
}
