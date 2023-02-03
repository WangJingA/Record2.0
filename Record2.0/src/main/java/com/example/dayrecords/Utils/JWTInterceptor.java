package com.example.dayrecords.Utils;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/**
 * 拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         String token = request.getHeader("token");
         Map<String,Object> map = new HashMap<>();
         try {
             DecodedJWT verify = JWTUtils.verify(token);
             return true;
         }catch (SignatureVerificationException e){
             map.put("msg","无效签名！");
             e.printStackTrace();
         }catch (TokenExpiredException e){
             map.put("msg","token过期！");
             e.printStackTrace();
         }catch (AlgorithmMismatchException e){
             map.put("msg","token算法不一致");
             e.printStackTrace();
         }catch (Exception e){
             map.put("msg","token无效!");
             e.printStackTrace();
         }
         map.put("state",false);
         // 将map转为json，然后将map的json数据返回给前端
         String jsonStr = new ObjectMapper().writeValueAsString(map);
         response.setContentType("application/json;charset=UTF-8");
         response.getWriter().println(jsonStr);
         return false;
     }

    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

   public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
