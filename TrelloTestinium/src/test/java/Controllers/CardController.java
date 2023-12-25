package Controllers;

import Base.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class CardController extends BaseAPI {

    public String CreateCard(String boardId,String listId ){
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("idBoard",boardId);
        parameters.put("idList",listId);
        parameters.put("name","TEST CARD");
        Response response = post("cards/",parameters);
        JsonPath cardPath = response.jsonPath();
        return cardPath.get("id");
    }

    public void UpdateCard(String cardId){
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("name","TEST 2");
        put("cards/"+cardId,parameters);
    }

    public void DeleteCard(String cardId){
        delete("cards/"+cardId);
    }

}
