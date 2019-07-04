package TestConfig;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestBase {

    @BeforeClass
    public static void TestSetup(){

        RestAssured.proxy(8888);

        RequestSpecification videogame_requestJSON = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setBasePath("/app/")
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml").build();

        RestAssured.requestSpecification = videogame_requestJSON;

        ResponseSpecification videogame_responseJSON = new ResponseSpecBuilder().expectResponseTime(lessThan(5000L)).expectStatusCode(200).build();

        RestAssured.responseSpecification = videogame_responseJSON;

    }


}
