package Step;

import TestConfig.TestBase;
import static io.restassured.RestAssured.*;

import TestConfig.VideoGame;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import static org.hamcrest.Matchers.is;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;


public class StepClass{

    //private String WebLink = "http://localhost:8080/app/videogames/";
    private Response response;
    //public RequestSpecification videogame_requestJSON;
    //public RequestSpecification videogame_requestXML;

    @Step
    public void TestSetUp(){
        RestAssured.proxy(8888);

        RequestSpecification  videogame_requestJSON = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setBasePath("/app/")
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml").build();

        RestAssured.requestSpecification = videogame_requestJSON;

        /*videogame_requestXML = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setBasePath("/app/")
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml").build();*/
    }

    @Step
    public void SearchGame(){
        response = SerenityRest.when().get("videogames/1");
    }

    @Step
    public void SearchIsExecutedSuccessfully(){
        response.then().statusCode(200);
    }

    @Step
    public void IShouldFindGame(String name){
        response.then().body("VideoGame.name",is(name));
    }








}
