package pages;
import elements.Field;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SetUpPages {
    WebDriver driver;
    public SetUpPages(WebDriver driver){
        this.driver=driver;
    }
    public String url = "https://trello.com/";
    public Link loginLink = new Link(By.cssSelector("a[href='/login']"));
    public Field emailField = new Field(By.cssSelector("input[id='user']"));
    public Field passwordField = new Field(By.cssSelector("input[id='password']"));
    public Link login = new Link(By.cssSelector("input[id='login']"));
}
