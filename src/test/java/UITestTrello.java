import conf.TestManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.TestPages;


public class UITestTrello extends TestManager {

    @Test(priority = 1)
    public void createBoard(){
        TestPages testPages = new TestPages(driver);
        testPages.addBoard.click();
        testPages.boardName.sendKeys(boardTitle + Keys.ENTER);
        sleep(5);
        Assert.assertEquals(testPages.board.getText(),boardTitle);
    }

    @BeforeGroups(groups = "1")
    public void createList(){
        TestPages testPages = new TestPages(driver);
        testPages.addList.sendKeys(listTitle + Keys.ENTER);
        sleep(1);
        Assert.assertEquals(testPages.listName.getText(),listTitle);
    }

    @Test (priority = 2, groups = "1")
    public void createCard(){
        TestPages testPages = new TestPages(driver);
        testPages.addCard.click();
        testPages.cardName.sendKeys(cardTitle+ Keys.ENTER);
        testPages.closeCard.click();
        Assert.assertEquals(testPages.card.getText(),cardTitle);
    }

    @Test (priority = 3, groups = "1")
    public void addAttachment(){
        TestPages testPages = new TestPages(driver);
        testPages.card.click();
        testPages.attachment.click();
        testPages.addAttachment.sendKeys(attachmentLink + Keys.ENTER);
        sleep(2);
        Assert.assertTrue(testPages.attachmentContent.isExist());
    }

}
