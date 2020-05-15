import conf.TestManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Ready extends TestManager {


    @Test (priority = 1)
    public void createBoard(){
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("div[class='board-tile mod-add']")).click();
        driver.findElement(By.cssSelector("input[class='subtle-input']")).sendKeys("Board" + Keys.ENTER);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class='js-board-editing-target board-header-btn-text']")).getText(),"Board");


    }
    @Test (priority = 2)
    public void createList(){
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("It's List" + Keys.ENTER);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[class='list-header-name mod-list-name js-list-name-input']")).getText(),"It's List");
    }

    @Test (priority = 3)
    public void createCard(){
        driver.findElement(By.cssSelector("a[class='open-card-composer js-open-card-composer']")).click();
        driver.findElement(By.cssSelector("textarea[class='list-card-composer-textarea js-card-title']")).sendKeys("Card"+ Keys.ENTER);
        driver.findElement(By.cssSelector("a[class='icon-lg icon-close dark-hover js-cancel']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class='list-card-title js-card-name']")).getText(),"Card");
    }
    @Test (priority = 4)
    public void addAttachment(){
        driver.findElement(By.cssSelector("span[class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector("a[class='button-link js-attach']")).click();
        driver.findElement(By.cssSelector("input[id='addLink']")).sendKeys("https://cdn.studydive.com/imgs/course/3269/10c88af2cbacd92be59d3fefe8081f79.png" + Keys.ENTER);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.cssSelector("a[class='icon-md icon-close dialog-close-button js-close-window dialog-close-button-light']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[class='attachment-thumbnail-preview js-open-viewer attachment-thumbnail-preview-is-cover']")).isEnabled());
    }


}
