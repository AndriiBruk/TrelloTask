import API.Board;
import API.RetrofitBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import java.io.IOException;

public class ApiTestTrello {
    private String boardId;
    private String idList;
    private String idCard;
    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    Board board = new Board();

    @Test (priority = 1)
    public void checkCreateBoard() throws IOException {
        String boardName = "I'm a board";

        Board createBoard = retrofitBuilder.getTrelloApi().createBoard(board,boardName).execute().body();
        boardId=createBoard.getId();
        Assert.assertEquals(createBoard.getName(),boardName);
    }

    @BeforeGroups(groups = "API")
    public void checkCreateList() throws IOException {
        String listName = "Hey, I'm a list";

        Board createList = retrofitBuilder.getTrelloApi().createList(board,boardId,listName).execute().body();
        idList = createList.getId();
        Assert.assertEquals(createList.getName(),listName);
    }

    @Test (priority = 2, groups = "API")
    public void checkCreateCard() throws IOException {
        String cardName = "Hey, I'm a card";

        Board createCard = retrofitBuilder.getTrelloApi().createCard(board,idList, cardName).execute().body();
        idCard = createCard.getId();
        Assert.assertEquals(createCard.getName(),cardName);
    }

    @Test (priority = 3, groups = "API")
    public void checkAddAttachment() throws IOException {
        String attachUrl = "https://cdn.studydive.com/imgs/course/3269/10c88af2cbacd92be59d3fefe8081f79.png";

        int code = retrofitBuilder.getTrelloApi().addAttachment(board,idCard, attachUrl).execute().code();
        Assert.assertEquals(code,200);
    }
}
