import org.testng.annotations.*;

/**
 * Created by zhangcheng on 2019/4/28.
 */
public class BasicAnnoation {


    @Test
    public void testCase1(){
        System.out.println("测试1");

    }


    @Test
    public void testCase2(){
        System.out.println("测试2");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod测试方法前运行");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod测试方法后运行");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClassZ；类运行前");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite；类运行前");
    }



}
