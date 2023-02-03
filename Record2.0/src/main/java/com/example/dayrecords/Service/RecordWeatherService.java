package com.example.dayrecords.Service;

import com.example.dayrecords.Utils.ResultDTO;

public interface RecordWeatherService {
    //获取指定城市的天气
    public ResultDTO getWeather(String city);
}
