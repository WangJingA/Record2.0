package com.example.dayrecords.Utils;

import com.google.gson.JsonObject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class HttpUtils<T> {
    @Bean
    RestTemplate Template(ClientHttpRequestFactory requestFactory){
        RestTemplate restTemplate = new RestTemplate();
        //设置请求返回数据格式为UTF-8
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory=new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);  //单位为ms
        factory.setConnectTimeout(5000); //单位为ms
        return  factory;
    }

    /**
     * get请求
     * @param url
     * @return
     */
    public static String httpGet(String url){
        RestTemplate restTemplate = new RestTemplate();
        //设置请求返回数据格式为UTF-8
        List<HttpMessageConverter<?>> httpMessageConverters = restTemplate.getMessageConverters();
        httpMessageConverters.stream().forEach(httpMessageConverter -> {
                    if (httpMessageConverter instanceof StringHttpMessageConverter) {
                        StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
                        messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
                    }
                });
        //设置Http Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("Accept-Encoding","gzip, deflate, br");
        headers.add("Accept","application/json, text/plain, */*");
        //设置请求媒体数据类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //设置返回媒体数据类型
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return restTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    /**
     * post请求
     * @param url
     * @param jsonData
     * @return
     */
    public static  String  httpPost(String  url, JsonObject jsonData){
        RestTemplate restTemplate = new RestTemplate();
        //设置请求返回数据格式为UTF-8
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/json");
        headers.add("Accept","application/json,text/plain,*/*");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = null;
        if(jsonData == null){
            entity = new HttpEntity<String>(null,headers);
        }else{
            entity = new HttpEntity<String>(jsonData.toString(),headers);
        }
        return restTemplate.postForObject(url,entity,String.class);
    }
}
