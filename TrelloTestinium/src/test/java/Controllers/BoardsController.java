package Controllers;

import Base.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class BoardsController extends BaseAPI {
    public String BoardID = "";
    public String ListID = "";

    public void createBoard(){
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("name","Test 2");

        Response createBoardRes = post("boards/",parameters);
        JsonPath boardPaths = createBoardRes.jsonPath();
        String boardId = boardPaths.get("id");

        Response listsResponse = get("boards/"+boardId+"/lists");
        JsonPath listsPath = listsResponse.jsonPath();
        String listId = listsPath.get("[0].id");
        BoardID = boardId;
        ListID = listId;
    }

    public void DeleteBoard(String Id){
        delete("boards/"+Id);
    }
}
