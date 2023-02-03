package com.example.dayrecords.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordModel {
    int id;
    String modelImg;
    int recordModelType;
    int recordRecommandImg;
    String recordModelName;
    String recordModelDesc;
    String recordModelContentId;
}
