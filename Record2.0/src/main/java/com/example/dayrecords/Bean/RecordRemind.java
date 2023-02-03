package com.example.dayrecords.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecordRemind {
    int recordId;
    @JsonFormat(pattern = "yyyy-MM-dd ")
//    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    Date recordCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd ")
//    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    Date recordRemindDate;
    int recordUserId;
    String recordRemindContent;
    String recordRemindTitle;
    String recordUserMail;
}
