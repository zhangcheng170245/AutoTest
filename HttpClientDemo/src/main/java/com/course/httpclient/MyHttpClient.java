package com.course.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by zhangcheng on 2019/5/11.
 */

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        String result=null;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client=new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        result  = EntityUtils.toString(entity, "utf-8");
        System.out.println(result);
    }

}
