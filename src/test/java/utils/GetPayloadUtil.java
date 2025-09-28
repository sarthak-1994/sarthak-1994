package utils;

import modal.Product;
import modal.updatepost.Reactions;
import modal.updatepost.UpdatePosts;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;


import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import static utils.RandomUtil.getRandomSentence;
import static utils.RandomUtil.getRandomString;

public class GetPayloadUtil {

    public static Random random=new Random();

    public static String getAuthPayLoad() throws IOException {
      return  getPayload();
    }

    public static String  getPayload() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/payload/AuthPayload.json")));
    }

    public static Product getProductRequest(){
        Product product=new Product();
        product.setTitle("assasa");
        product.setDescription("A description");
        product.setCategoryId(50);
        product.setPrice(10);
        product.setImages(new ArrayList<>(List.of("https://placehold.co/600x401")));
        return product;
    }

    public static UpdatePosts getUpdatePostRequest() {
        try{
        ObjectMapper obj= new ObjectMapper();
        return obj.readValue(Paths.get("src/test/java/payload/updatePost.json").toFile(), UpdatePosts.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static UpdatePosts getRequestForUpdateReactionsInPost(){
        UpdatePosts updatePosts=  getUpdatePostRequest();
        Reactions reactions=new Reactions();
        reactions.setLikes(random.nextInt(1000));
        reactions.setDislikes(random.nextInt(1000));
        updatePosts.setReactions(reactions);
        return updatePosts;
    }

    public static UpdatePosts getRequestForUpdateTitleInPost(){
        UpdatePosts updatePosts=  getUpdatePostRequest();
        updatePosts.setTitle(getRandomSentence(15));
        return updatePosts;
    }

}
