package tests.posts;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static RequestSpecification rs;

    @BeforeTest
    public void setup(){
        rs=new RequestSpecBuilder().setBaseUri("https://dummyjson.com")
               .addHeader("Content-Type","application/json").build();
    }
}
