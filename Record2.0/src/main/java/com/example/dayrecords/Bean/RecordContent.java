package com.example.dayrecords.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordContent implements Serializable {
    private Integer recordId;
    private Integer recordType;
    private Integer recordUser;
    private String recordContent;
    private String recordFamily;
    private String recordWeather;
    private String recordMood;
    private String recordDate;
    private String recordImg;
    private String recordTitle;
    private int recordRecommandImg;
    private String recordSign;
    private int recordStatus;
}
