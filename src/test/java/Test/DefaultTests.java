package Test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DefaultTests {

    @Test(priority = 3)
    public void test1(){
        System.out.println("Test 1");
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(priority = 1, enabled = false)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test()
    public void test4(){
        System.out.println("Test 4");
    }
}
