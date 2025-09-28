package test.auth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static utils.GetPayloadUtil.getAuthPayLoad;

public class BaseTest {

    public static String token ;
    public RequestSpecification reqSpec;

    static {
        try {
            token = getToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @BeforeClass
    public void setup() throws IOException {
        reqSpec=buildRequestSpec(token);
    }

    public RequestSpecification  buildRequestSpec(String token){

        return new RequestSpecBuilder()
                                        .setBaseUri("https://dummyjson.com")
                                         .addHeader("Authorization","Bearer"+" "+token)
                                          .addFilter(new AuthFilter())
                                          .build();
    }

    public static String getToken() throws IOException {
         return RestAssured.given()
                .baseUri("https://dummyjson.com/").given().contentType("application/json").log().all()
                .body(getAuthPayLoad())
                .post("auth/login")
                .then().log().all().assertThat().statusCode(200).extract().path("accessToken");
    }
}
