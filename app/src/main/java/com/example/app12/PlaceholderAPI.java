package com.example.app12;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlaceholderAPI {
    @GET("posts")
    Call<List<Post>> getPosts();
    @POST("posts")
    Call<Post> postPost(@Body Post data);
    @DELETE("posts/{id}")
    Call<Post> deletePost(@Path("id") int itemId);
}