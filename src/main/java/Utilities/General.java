package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class General {

    public static void takeScreenShot(WebDriver driver, String path, String title){

        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append(title);
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".png");

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File(stringBuilder.toString()));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Browser getBrowserFromString(String browserString){
        browserString = browserString.toLowerCase();

        switch (browserString){

            case "chrome":{
                System.out.println("Si viene bien...");
                return Browser.Chrome;
            }
            case "firefox":{
                return Browser.Firefox;
            }
            case "edge":{
                return Browser.Edge;
            }
        }

        return Browser.Chrome;
    }
}
