package com.zhangcheng.testng.Suite.groups;

import org.testng.annotations.Test;

/**
 * Created by zhangcheng on 2019/5/5.
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void stu1(){
        System.out.println("GroupsOnClass3333中的teacher1运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass3333中的teacher2运行");
    }
}
