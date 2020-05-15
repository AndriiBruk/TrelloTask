package pages;

import elements.Field;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPages {
    private WebDriver driver;
    public TestPages(WebDriver driver){this.driver = driver;}
    public Link addBoard = new Link(By.cssSelector("div[class='board-tile mod-add']"));
    public Field boardName = new Field(By.cssSelector("input[class='subtle-input']"));
    public Field board = new Field(By.cssSelector("span[class='js-board-editing-target board-header-btn-text']"));

    public Field addList = new Field(By.cssSelector("input[name='name']"));
    public Field listName = new Field(By.cssSelector("textarea[class='list-header-name mod-list-name js-list-name-input']"));

    public Link addCard = new Link(By.cssSelector("a[class='open-card-composer js-open-card-composer']"));
    public Field cardName = new Field(By.cssSelector("textarea[class='list-card-composer-textarea js-card-title']"));
    public Link closeCard = new Link(By.cssSelector("a[class='icon-lg icon-close dark-hover js-cancel']"));
    public Link card = new Link(By.cssSelector("span[class='list-card-title js-card-name']"));

    public Link attachment = new Link(By.cssSelector("a[class='button-link js-attach']"));
    public Field addAttachment = new Field(By.cssSelector("input[id='addLink']"));
    public Link attachmentContent = new Link(By.cssSelector("a[class='attachment-thumbnail-preview js-open-viewer attachment-thumbnail-preview-is-cover']"));
}
