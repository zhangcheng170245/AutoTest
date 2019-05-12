package com.course.getcookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhangcheng on 2019/5/12.
 */
public class MyCookiesForGet {
    private String url;
    //使用rResourceBundle 读取配置类
    private ResourceBundle resourceBundle;
    //用来存储cookies信息的变量
    private CookieStore store;


    @BeforeTest
    public void BeforeTest() {
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //读取配置文件中的url；
        url = resourceBundle.getString("test.url");
    }

    @Test
    public void testGetCookies()throws IOException{
        String result = null;
        //   从配置文件中 拼接测试的  url
        String uri = resourceBundle.getString("getCookies.uri");
        String testurl = this.url + uri;
       // System.out.println(this.url);

        // 测试逻辑代码书写
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        //执行url
        HttpResponse response= client.execute(get);
        HttpEntity entity = response.getEntity();
        result= EntityUtils.toString(entity,"utf-8");
        System.out.println(result);

       //获取cookies信息
        CookieStore store = client.getCookieStore();
        //this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name
                    + ";  cookie value = " + value);
        }
    }


    @Test(dependsOnMethods = "testGetCookies")
    public void testWithMethod()throws IOException{
        //通过配置文件的名的方法
        String uri = resourceBundle.getString("test.get.with.cookies");
        String testurl = this.url + uri;
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie信息
        client.setCookieStore(this.store);
        HttpResponse response =  client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if (statusCode==200){
            String resutlt = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(resutlt);

        }

    }















}