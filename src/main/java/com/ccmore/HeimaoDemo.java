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

public class HeimaoDemo {
    public static void main(String[] args) throws IOException, ParseException {
        long time = System.currentTimeMillis()/1000;
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
//       Map<String, Object> map = (Map<String, Object>)JSON.parse(EntityUtils.toString(entity2));

//        getdata(httpclient, (Map<String, Object>)map.get("data"));
        getdata(httpclient, null);


    }

     private static void getdata( CloseableHttpClient httpclient, Map<String, Object> param) throws IOException, ParseException {
         HttpGet postMethod = new HttpGet("https://tousu.sina.com.cn/api/company/received_complaints?couid=6340925133&page_size=10&page=6");
//         postMethod.addHeader("user-agent","https://company.xfb315.com/");
//         postMethod.addHeader("referer","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
//         postMethod.addHeader("Content-type","application/json; charset=UTF-8");
//         postMethod.addHeader("authorization",param.get("Authorization").toString());
//         postMethod.addHeader("cookie", "TOUSU-SINA-CN=; UOR=,tousu.sina.com.cn,; UM_distinctid=17240942acf91-05f4aa3dab6743-54123310-144000-17240942ad0ee; CNZZDATA1273941306=776506511-1590221517-%7C1590221517; SINAGLOBAL=27.38.29.11_1590221648.44733; Apache=27.38.29.11_1590221648.44735; SCF=ArEKPCk5WUpVlMa1Ey4hvVODp4exsuN3L8_c6FyWkwhKzZpHK2y5-ai3YvAba5jMuC6RrpEzv0wS17TGaJ1nmMM.; U_TRS1=0000000b.caf255a7.5ec8db91.d292098b; U_TRS2=0000000b.cafc55a7.5ec8db91.d184d7ef; ULV=1590222938714:2:2:2:27.38.29.11_1590221648.44735:1590221351618; SUB=_2AkMplG6vdcPxrAVSnPgczm7jb45H-jyaQQdZAn7tJhMyAhj_7lc-qSVutBF-XB_eZtv9Z8LJ_h8irC1GZKxxXPcs; SUBP=0033WrSXqPxfM72wWs9jqgMF55529P9D9WFGCDGG.WbnQmBa5GnWPEEZ5JpVF02feo2NeheEeoqR");
//         postMethod.addHeader("Access-Control-Allow-Credentials", "true");
//         postMethod.addHeader("Access-Control-Allow-Origin", "* ");



         CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
         HttpEntity entity2 = closeableHttpResponse.getEntity();
         int code = closeableHttpResponse.getCode();
         System.out.println(code);
         String x = EntityUtils.toString(entity2);

         System.out.println(x);
     }



}
