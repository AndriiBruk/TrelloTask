package API;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrelloApi {

    @POST("/1/boards/")
    Call<Board> createBoard (@Body Board board, @Query("name") String boardName);

    @POST("/1/boards/{id}/lists")
    Call<Board> createList (@Body Board board, @Path("id") String boardId, @Query("name") String listName);

    @POST("/1/cards")
    Call<Board> createCard (@Body Board board, @Query("idList") String idList, @Query("name") String cardName);

    @POST("/1/cards/{id}/attachments")
    Call<Board> addAttachment (@Body Board board, @Path("id") String idCard, @Query("url") String attachUrl);
}
