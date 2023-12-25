package Base;

import Constants.ConstantsAPI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.codehaus.groovy.transform.tailrec.RecursivenessTester;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

public class BaseAPI {
    public BaseAPI(){
    }

    protected Response post(String url, Map<String,Object> parameters){
        parameters.put("key",ConstantsAPI.API_KEY);
        parameters.put("token", ConstantsAPI.TOKEN);
        Response response =  RestAssured
                .given()
                .baseUri(ConstantsAPI.BASE_URL).formParams(parameters)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .post(url);

        return response;
    }
    protected Response get(String url){
        return   RestAssured
                .given()
                .baseUri(ConstantsAPI.BASE_URL).when().get(url+"?key="+ConstantsAPI.API_KEY + "&token="+ConstantsAPI.TOKEN);
    }
    protected Response put(String url,  Map<String,Object> parameters){
        parameters.put("key",ConstantsAPI.API_KEY);
        parameters.put("token", ConstantsAPI.TOKEN);

       Response response =   RestAssured
               .given()
               .baseUri(ConstantsAPI.BASE_URL).formParams(parameters)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .put(url);

       return  response;
    }
    protected Response delete(String url){
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("key",ConstantsAPI.API_KEY);
        parameters.put("token", ConstantsAPI.TOKEN);

        Response response =   RestAssured
                .given()
                .baseUri(ConstantsAPI.BASE_URL).formParams(parameters)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .delete(url);

        return  response;
    }

}
