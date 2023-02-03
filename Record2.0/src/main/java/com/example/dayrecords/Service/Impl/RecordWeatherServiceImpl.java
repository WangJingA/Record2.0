package com.example.dayrecords.Service.Impl;


import com.alibaba.fastjson.JSONObject;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Service.RecordWeatherService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RecordWeatherServiceImpl implements RecordWeatherService {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public ResultDTO getWeather(String city) {
        String moduleName = "RecordWeatherServiceImpl-getWeather";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s",moduleName));
        String url = "http://portalweather.comsys.net.cn/weather03/api/weatherService/getDailyWeather?cityName="+city;
        String forObject = restTemplate.getForObject( url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        log.info(String.format(">>>执行%s方法耗时%s",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),jsonObject);
    }
}
