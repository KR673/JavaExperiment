package com.wxb.commontest.modules;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/30 13:53
 * @Version: 1.0
 */
@RequestMapping("/updateFile/")
@RestController()
public class httpClientTest {


    @PostMapping("/update")
    public String updateFile(@RequestParam MultipartFile file,  String ImagePath) throws IOException {

        String url = "http://htyu.zhongyewx.com.cn/AjaxControls/UploadImage.ashx";

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.addBinaryBody("myfile",file.getInputStream(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
        builder.addTextBody("imageUrl", ImagePath);

        HttpEntity build = builder.build();

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            httpPost.setEntity(build);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String url = "http://htyu.zhongyewx.com.cn/AjaxControls/UploadImage.ashx";

        File file = new File("C:\\Users\\Administrator\\Desktop\\Snipaste_2019-05-21_09-05-45.jpg");

        if(!file.exists()){
            System.out.println("no file");
            return;
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        FileInputStream fileInputStream = new FileInputStream(file);
        FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA, "Snipaste_2019-05-21_09-05-45.jpg");

        builder.addBinaryBody("myfile",new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, "Snipaste_2019-05-21_09-05-45.jpg");
        builder.addTextBody("ImagePath", "ImageTest");

        HttpEntity build = builder.build();

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url){{
                setEntity(build);
            }};
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(resultString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }




}
