package com.wxb.commontest.HttpClientTest;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;

/**
 * @Description: httpclient
 * @Author: WangXiaoBo
 * @Date: 2019/4/12 13:56
 * @Version: 1.0
 */
public class HttpClientTest {
    public static void main(String[] args) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder("http://192.168.1.110:8080/tuiGaung/publicApi/selectLeYuMessage");

            URI uri = builder.build();

            // 创建http post请求
            HttpPost httpPost = new HttpPost(uri);

            StringEntity entity = new StringEntity("123", ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            // 执行请求
            response = httpclient.execute(httpPost);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}