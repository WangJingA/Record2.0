package com.example.dayrecords.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;


public class JWTUtils {
    private static final String SING = "!QAZWSX234EDCRFV45TGB6YHNUJM78KKI";

    /**
     * 获取token
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        //六十分钟过期
        instance.add(Calendar.MINUTE,5);
        JWTCreator.Builder builder = JWT.create();
        //将map中的payload放入
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = "";
        try {
            token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SING));
        }catch (TokenExpiredException e){
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 验证token的合法性
     *
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return verify;
    }
}
