package com.miaus.yehor.mojam.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;
    private static ThreadLocal <WebDriver> DRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    @BeforeClass
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        /*WebDriverManager.chromedriver()
                 .version("2.40").setup();*/
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DRIVER_CONTAINER.set(driver);
    }

    WebDriver getDriver(){
        return DRIVER_CONTAINER.get();
    }
    //@AfterMethod
    public void quit(){
        if (driver !=null){
            //driver.manage().deleteAllCookies();
            driver.quit();
            DRIVER_CONTAINER.remove();
        }
    }
}
