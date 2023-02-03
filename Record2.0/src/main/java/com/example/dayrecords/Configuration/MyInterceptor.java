package com.example.dayrecords.Configuration;

import com.example.dayrecords.Utils.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyInterceptor implements WebMvcConfigurer {
    public void addInterceptor(InterceptorRegistry interceptorRegistry){
        //添加拦截请求
        interceptorRegistry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**")
                //放行请求
                .excludePathPatterns("record/login");
    }
}
