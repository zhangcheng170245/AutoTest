import org.testng.annotations.Test;

/**
 * Created by zhangcheng on 2019/5/5.
 */
public class IgonreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1执行");
    }

    //忽略这个方法 添加忽略方法
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2执行");
    }

    //忽略这个方法  默认为true
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3执行");
    }


}


