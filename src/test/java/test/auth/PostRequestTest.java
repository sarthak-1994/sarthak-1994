package test.auth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import modal.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.GetPayloadUtil.getProductRequest;

public class PostRequestTest {

    private RequestSpecification reqSpec;

    @BeforeTest
    public void setup(){

        reqSpec=new RequestSpecBuilder()
                                         .setBaseUri("https://api.escuelajs.co/api/v1/products")
                                         .addHeader("Content-Type","application/json")
                                         .build();
    }

    @Test
    public void testPostRequestUsingPojo(){
      Response response=  given(reqSpec).body(getProductRequest()).log().all().when().post().then().log().all().statusCode(201).extract().as(Response.class);
        Assert.assertEquals(response.getCategoryId(),1);
    }
}
