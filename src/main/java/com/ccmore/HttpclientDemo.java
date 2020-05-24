package com.ccmore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HttpclientDemo {
    public static void main(String[] args) throws IOException, ParseException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost postMethod = new HttpPost("https://company.api.xfb315.com/v1/auth/login");
//        postMethod.addHeader("user-agent","https://company.xfb315.com/");
//        postMethod.addHeader("referer","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
//        postMethod.addHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
//
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("account", "深圳市升学文化传播有限公司"));
//        nvps.add(new BasicNameValuePair("pwd", "123456zhao"));
//        nvps.add(new BasicNameValuePair("acccount_type", "uname"));
//        nvps.add(new BasicNameValuePair("client_type", "web"));
//        nvps.add(new BasicNameValuePair("device_id", ""));
//        postMethod.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("utf-8")));
//
//
//        CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
//        HttpEntity entity2 = closeableHttpResponse.getEntity();
//        int code = closeableHttpResponse.getCode();
//        System.out.println(code);
//        System.out.println(EntityUtils.toString(entity2));

//        EntityUtils.consume(entity2);
//       Map<String, Object> map = (Map<String, Object>)JSON.parse(EntityUtils.toString(entity2));

//        getdata(httpclient, (Map<String, Object>)map.get("data"));
        getdata(httpclient, null);


    }

     private static void getdata( CloseableHttpClient httpclient, Map<String, Object> param) throws IOException, ParseException {
         HttpGet postMethod = new HttpGet("https://company.api.xfb315.com/v1/tousu/handling/list?company_status=1&page=1&limit=10&tsnumber=&mobile=&name=&export=&start_at=&end_at=&subtype_id=&_t=1590218343018");
//         postMethod.addHeader("user-agent","https://company.xfb315.com/");
//         postMethod.addHeader("referer","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
         postMethod.addHeader("Content-type","application/json; charset=UTF-8");
//         postMethod.addHeader("authorization",param.get("Authorization").toString());
         postMethod.addHeader("Authorization", "3WEHvSt4+ujK427OXMOMn+2x3uVtilVPng5qN9ViKbChJZQbpd5Ocw==");
//         postMethod.addHeader("Access-Control-Allow-Credentials", "true");
//         postMethod.addHeader("Access-Control-Allow-Origin", "* ");



         CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
         HttpEntity entity2 = closeableHttpResponse.getEntity();
         int code = closeableHttpResponse.getCode();
         System.out.println(code);
         System.out.println(EntityUtils.toString(entity2));
     }



}
