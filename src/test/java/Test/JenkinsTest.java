package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsTest {

    @Test
    public void testJenkins1(){
        System.out.println("Esto es solo una prueba...");
        Assert.assertTrue(true);
    }
}
