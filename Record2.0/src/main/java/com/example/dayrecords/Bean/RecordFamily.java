package com.example.dayrecords.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordFamily {
    private int id;
    private String recordFamily;
    private String recordFamilyFont;
}
