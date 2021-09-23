import com.softeem.junit.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author lyming
 * @date 2020/12/22 4:21 下午
 */
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        System.out.println(calculator.add(2, 10));
    }

    @Test
    public void testSubtract() {
        System.out.println(calculator.subtract(2, 10));
    }

    @Test
    public void testMultply() {
        System.out.println(calculator.mutiply(2, 10));
    }

    @Test
    /**
     * 没有出先!不一定代表是正确的
     * 出先了!不一定代表是错误的
     */
    public void testDevide() {
        System.out.println(calculator.devide(1, 0));
    }


    /**
     * 被@Ignore标注的测试用例方法不会被执行
     */
    @Ignore
    @Test
    public void testIgnore() {
        System.out.println("我被@Ignore注解标注了");
    }

    /**
     * @Test的expected属性规定该测试用例抛出指定的异常才会成功
     */
    @Test(expected = ArithmeticException.class)
    public void testExpect() {
        System.out.println(calculator.devide(1, 0));
    }

    /**
     * @Test的timeout属性规定该测试方法必须在多少毫秒内完成,否则报错
     */
    @Test(timeout = 1000)
    public void testTimeout() {

        try {
            Thread.sleep(3000);
            System.out.println("我休息了3秒钟");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//            TimeUnit.SECONDS.sleep(3);
//            System.out.println("我休息了3秒钟");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testAssert() {
        Assert.assertEquals(12, calculator.add(1, 10));
    }

    /**
     * 必须是静态
     */
    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("我是BeforeClass");
    }

    @Before
    public void testBefor() {
        System.out.println("我是Before");
    }

    @After
    public void testAfter() {
        System.out.println("我是After");
    }

    /**
     * 必须是静态
     */
    @AfterClass
    public static void testAfterClass() {
        System.out.println("我是AfterClass");
    }

}
