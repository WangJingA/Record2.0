package com.example.dayrecords.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

/*
分页拦截器,使用mybatis-plus的分页拦截器
 */
@Configuration
public class pageInrercetor {
    @Bean
    public MybatisPlusInterceptor pageInterceptor(){
        MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
        //分页拦截器
        PaginationInnerInterceptor innerInterceptor=new PaginationInnerInterceptor();
        //点击最后页后跳转回去首页
        innerInterceptor.setOverflow(true);
        interceptor.addInnerInterceptor(innerInterceptor);
        return interceptor;
    }
}
