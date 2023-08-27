package Test;

import org.testng.annotations.Test;

public class GroupExample {

    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(groups = {"regression"})
    public void test2(){
        System.out.println("Test 2");
    }
    @Test(groups = {"smoke"})
    public void test3(){
        System.out.println("Test 3");
    }
    @Test(groups = {"regression"})
    public void test4(){
        System.out.println("Test 4");
    }
    @Test(groups = {"smoke", "regression"})
    public void test5(){
        System.out.println("Test 5");
    }
}
