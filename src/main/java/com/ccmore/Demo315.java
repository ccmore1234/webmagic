package com.ccmore;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Demo315 {
    public static void main(String[] args) throws IOException, ParseException {
//        long time = System.currentTimeMillis()/1000;
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost postMethod = new HttpPost("https://login.sina.com.cn/sso/login.php?client=ssologin.js(v1.4.19)&_="+time);
//        postMethod.addHeader("Connection","keep-alive");
//        postMethod.addHeader("user-agent","UOR=,tousu.sina.com.cn,; ULV=1590221351618:1:1:1::; UM_distinctid=17240942acf91-05f4aa3dab6743-54123310-144000-17240942ad0ee; SINAGLOBAL=27.38.29.11_1590221648.44733; Apache=27.38.29.11_1590221648.44735");
//        postMethod.addHeader("Host","login.sina.com.cn");
//        postMethod.addHeader("referer","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
//        postMethod.addHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
//
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("entry", "finance"));
//        nvps.add(new BasicNameValuePair("gateway", "1"));
//        nvps.add(new BasicNameValuePair("from", "uname"));
//        nvps.add(new BasicNameValuePair("savestate", "web"));
//        nvps.add(new BasicNameValuePair("qrcode_flag", ""));
//        nvps.add(new BasicNameValuePair("useticket", ""));
//        nvps.add(new BasicNameValuePair("pagerefer", ""));
//        nvps.add(new BasicNameValuePair("vsnf", ""));
//        nvps.add(new BasicNameValuePair("su", "MTUyMTcwMzIyNjg="));
//        nvps.add(new BasicNameValuePair("service", "sso"));
//        nvps.add(new BasicNameValuePair("servertime", Long.toString(time)));
//        nvps.add(new BasicNameValuePair("nonce", "FASLK3"));
//        nvps.add(new BasicNameValuePair("pwencode", "rsa2"));
//        nvps.add(new BasicNameValuePair("rsakv", "1330428213"));
//        nvps.add(new BasicNameValuePair("sp", "5b8435d7737bf8b9201100e9b9568a9331ac9ffbae5c2b59f8ffaf5adeb356319bbcdc324842eea168ea3fbf99fa5cb5431e2ba8a72451e79f21615686b48e5efab74822629e28218f2bb074428dc71d80246c58d24eaceb858a2462ad739238261767ca3be4e986ba73f9ae25b4e7c72d1d1a15b735b2c60ea24bd38085989b"));
//        nvps.add(new BasicNameValuePair("sr", "1536*864"));
//        nvps.add(new BasicNameValuePair("domain", "sina.com.cn"));
//        nvps.add(new BasicNameValuePair("prelt", "62"));
//        nvps.add(new BasicNameValuePair("returntype", "TEXT"));
//        postMethod.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("utf-8")));
//
//
//        CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
//        HttpEntity entity2 = closeableHttpResponse.getEntity();
//        int code = closeableHttpResponse.getCode();
//        System.out.println(code);
//        System.out.println(EntityUtils.toString(entity2));
//
//        EntityUtils.consume(entity2);
////       Map<String, Object> map = (Map<String, Object>)JSON.parse(EntityUtils.toString(entity2));
//
////        getdata(httpclient, (Map<String, Object>)map.get("data"));
        getdata(httpclient, null);


    }

     private static void getdata( CloseableHttpClient httpclient, Map<String, Object> param) throws IOException, ParseException {
         HttpPost postMethod = new HttpPost("http://company.315xft.cn/complaint/list/compromising");
         postMethod.addHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
         postMethod.addHeader("Cookie", "acw_tc=784c10e415902225692068038eb54004f9600b8a6d9226239be6132132f3e1; uid=K8V5ZbAxw7WytddAnvLC4vmTB-jq8KXHfwV57ZOfNZp3LQUq7ferBr0CeAfLdATbOun9semapNmfYXlqJ_vXpvETbEdB5StxeAL6msnoYipG1plpB4rjziWpgHksnKe_mnUgkA..; JSESSIONID=965f7299-4de1-47c5-bfe7-ba2d8bf98944; rememberMe=qqbAVVsjcD22y/pjbv8p803IaiwStigvXMEm6JMB04z/tU9eTgixvqlxM3MPu/U9I0PR0nnI8MQXDaXsDx1YOy75+bQvYo0CuVUF5EaEKHWwphQmjBSuuSOGKvJ/WwLLIEW5UKJ8TmifleGP9rbatmzowr8hfFS4e8pu4CtaKqRqWt2tuGLjKmZz+ZYA3dYxWALnMUMTM6v6Teqh+7vQ89PHzkPert0+51aGlsSNSFG35yWe7/Ihj4WKBNuj5FKiiDu5WDr94nUP70k8Y7Ao2E/9wu6P1razcUWrIqPzi6B7cAfcAloAOJynAANAnzstEB1qwG4xTcfBUzxWSJKrZszHnqohuDKBp3ilpvh8UrD8ohKXEZ4z5NNXOOdFgsPHNLqDw/ea9/NaNEyw74Xx5/pZVnRK+z4yx7RRaIq0MQJ5uVDcY50Gpi8VeeyAURguoxR9VzOKEsCuCaAPvhv4u8gR7j/xZQA8ilx/gLzBI9axm5itTBz19cOfBqhHf/zs; pgv_pvi=344854528; pgv_si=s9588959232");


         List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("pageSize", "1000"));
        nvps.add(new BasicNameValuePair("curPage", "1"));
        nvps.add(new BasicNameValuePair("sortName", ""));
        nvps.add(new BasicNameValuePair("sortOrder", ""));
        postMethod.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("utf-8")));

         CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
         HttpEntity entity2 = closeableHttpResponse.getEntity();
         int code = closeableHttpResponse.getCode();
         System.out.println(code);
         System.out.println(EntityUtils.toString(entity2));
     }



}
