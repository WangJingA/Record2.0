package com.example.dayrecords.Configuration;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

public class MarixConfiguration implements WebMvcConfigurer {
    public  void configurePathMatch(PathMatchConfigurer configurer) {
        //取消请求链接分号后面内容取消的设置
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        //将url路径帮助器添加进配置
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
