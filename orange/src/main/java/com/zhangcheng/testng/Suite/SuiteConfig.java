package com.zhangcheng.testng.Suite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Created by zhangcheng on 2019/4/28.
 */
public class SuiteConfig {

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite；运行");
    }


    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite；运行");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClassZ；类运行前");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass；类运行前");
    }



}
