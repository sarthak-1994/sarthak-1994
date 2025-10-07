package tests.auth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAuthUserTest extends BaseTest {


    @Test
    public void assertAuthUser() throws InterruptedException {
        System.out.println(reqSpec.log().all());
        Response response =given(reqSpec).when().log().all().get("/auth/me");
        response.then().log().all();
        response.then().statusCode(200).assertThat().body("firstName",equalTo("Emily"));
        Thread.sleep(Duration.ZERO.plusMinutes(1));
    }

    @Test
    public void assertSecondAuthUser() throws IOException {
        given(buildRequestSpec(token)).log().all().when().log().all().get("/auth/me").then().assertThat().statusCode(200);

    }
}
