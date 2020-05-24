package com.ccmore;

import com.baidu.aip.util.Base64Util;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class BaiduApiDemo {
    public static void main(String[] args) throws IOException, ParseException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=P1l8Xk2eNberOLTDrqQbCEWD&client_secret=OGSmraTmBgFLNlb2tDmUqNoHbZymzIix");
//        CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
//        HttpEntity entity2 = closeableHttpResponse.getEntity();
//        int code = closeableHttpResponse.getCode();
//        System.out.println(code);
//        System.out.println(EntityUtils.toString(entity2));

//
        HttpPost postMethod = new HttpPost("https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic");
        postMethod.addHeader("content-type","application/x-www-form-urlencoded;");
//        postMethod.addHeader("Connection", "Keep-Alive");


        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        byte[] imgData = FileUtil.readFileByBytes("F://image.jpg");
        String imgStr = Base64Util.encode(imgData);
//        String imgParam = URLEncoder.encode(imgStr, "UTF-8");


        nvps.add(new BasicNameValuePair("access_token", "24.1604fe906b5cd0dec83a3585d52d7b67.2592000.1592846383.282335-20031120"));
        nvps.add(new BasicNameValuePair("image", imgStr));
        postMethod.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));

//        postMethod.setEntity(new StringEntity("image="+param, Charset.forName("UTF-8")));
        CloseableHttpResponse closeableHttpResponse = httpclient.execute(postMethod);
        HttpEntity entity2 = closeableHttpResponse.getEntity();
        int code = closeableHttpResponse.getCode();
        System.out.println(code);
        System.out.println(EntityUtils.toString(entity2));

//        // 初始化一个AipOcr
//        AipOcr client = new AipOcr("20031120", "P1l8Xk2eNberOLTDrqQbCEWD", "OGSmraTmBgFLNlb2tDmUqNoHbZymzIix");
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//
//
//        // 调用接口
//        String path = "F://image.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));


//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
//        try {
//            // 本地文件路径
//            String filePath = "F://image.jpg";
//            byte[] imgData = FileUtil.readFileByBytes(filePath);
//            String imgStr = Base64Util.encode(imgData);
//            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
//
//            String param = "image=" + imgParam;
//
//            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken = "24.1604fe906b5cd0dec83a3585d52d7b67.2592000.1592846383.282335-20031120";
//
//            String result = HttpUtil.post(url, accessToken, param);
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
