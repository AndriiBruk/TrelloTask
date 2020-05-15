package conf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.SetUpPages;

import java.util.concurrent.TimeUnit;

public class TestManager {
    public static WebDriver driver;

    private static final String email = "fstyle.hu@gmail.com";
    private static final String password = "aBc123654789";
    private static final String property = "webdriver.chrome.driver";
    private static final String pathToDriver = "src/main/resources/chromedriverNew.exe";

    public String boardTitle = "Board";
    public String listTitle = "It's List";
    public String cardTitle = "Card";
    public String attachmentLink ="https://cdn.studydive.com/imgs/course/3269/10c88af2cbacd92be59d3fefe8081f79.png";

    @BeforeClass ()
    public static void setUp(){
        System.setProperty(property, pathToDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        SetUpPages setUpPages = new SetUpPages(driver);
        driver.get(setUpPages.url);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        setUpPages.loginLink.click();
        setUpPages.emailField.sendKeys(email);
        sleep(1);
        setUpPages.login.click();
        setUpPages.passwordField.sendKeys(password + Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.cssSelector("button[class='_2ZNy4w8Nfa58d1 js-open-header-member-menu _3R2LYccoXhpfv9']")).isEnabled());
    }

    @AfterClass()
    public static void tearDown(){driver.quit();}

    public static WebDriver getDriver(){
        return driver;
    }

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
