package com.example.dayrecords.Controller.Weather;

import com.example.dayrecords.Service.RecordWeatherService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/weather")
@Slf4j
public class WeatherController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RecordWeatherService weatherService;
    @GetMapping("getCityWeather")
    @ResponseBody
    public ResultDTO getCityWeather(@RequestParam("city") String city){
        String module = "getCityWeather-controller";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入%s处理方法",module));
        ResultDTO weather = weatherService.getWeather(city);
        log.info(String.format(">>>>执行处理方法共耗时%s毫秒",System.currentTimeMillis()-startTime));
        return weather;
    }
}
