package com.zhangcheng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by zhangcheng on 2019/5/6.
 */
public class BasicAnnotation {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());

    }
}
