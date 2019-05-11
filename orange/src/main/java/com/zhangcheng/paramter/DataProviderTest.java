package com.zhangcheng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by zhangcheng on 2019/5/6.
 */
public class DataProviderTest {
    //方法注解
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age ){
        System.out.println("name="+name+"; age="+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData() {
        Object[][] o=new Object[][]{
                {"zhangs",10},
                {"lisi",20},
                {"wanggu",30}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age ){
        System.out.println("test111方法 name="+name+";age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age ){
        System.out.println("test222方法 name="+name+";age="+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu ",30},
                    {"zhaoliu",35}
            };
        }
        return result;
    }
}
