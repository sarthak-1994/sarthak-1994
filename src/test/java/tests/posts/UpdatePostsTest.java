package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.testng.AssertJUnit.assertEquals;
import static utils.GetPayloadUtil.*;

public class UpdatePostsTest extends BaseTest {


    @Test()
    public void validateReactionsAreUpdatedInUpdatePost() {
        modal.updatepost.UpdatePosts updatePostsRequest=getRequestForUpdateReactionsInPost();
        Response response = given(rs).body(updatePostsRequest)
                                     .when().put("/posts/2")
                                      .then().log().all()
                                       .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals(response.getBody().jsonPath().getInt("reactions.dislikes"),updatePostsRequest.getReactions().getDislikes());

    }


    @Test()
    public void validateTitleAreUpdatedInUpdatePost() {
        modal.updatepost.UpdatePosts updatePostsRequest=getRequestForUpdateTitleInPost();
        Response response = given(rs).body(updatePostsRequest)
                .when().put("/posts/2")
                .then().log().all()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals(response.getBody().jsonPath().getString("title"),updatePostsRequest.getTitle());

    }

}
