package com.example.app12;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class APIData {
    public static void addDataToApi(String id, String name, String author) {
        Retrofit retrofit = RetrofitFactory.getRetrofit( "http://192.168.0.105:3000/");
        PlaceholderAPI placeHolderAPI =
                retrofit.create(PlaceholderAPI.class);
        Call<Post> call = placeHolderAPI.postPost(new Post(id, name, author));
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response)
            {
                if (response.isSuccessful()) {
                    Post post = response.body();
                    Log.d("Success", post.getId() + "; " + post.getName() + "; " + post.getAuthor());
                } else {
                    Log.e("Fail", "Error: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public static void getDataFromApi() {
        Retrofit retrofit = RetrofitFactory.getRetrofit(
                "http://192.168.0.105:3000/"
        );
        PlaceholderAPI placeHolderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List<Post>> call = placeHolderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call,
                                   Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    for (Post post : posts) {
                        Log.d("Success", post.getName() + "; " +
                                post.getAuthor());
                    }
                } else {
                    Log.e("Fail", response.toString());
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public static void deleteDataFromApi(int id) {
        Retrofit retrofit = RetrofitFactory.getRetrofit(
                "http://192.168.0.105:3000/"
        );
        PlaceholderAPI placeHolderAPI =
                retrofit.create(PlaceholderAPI.class);
        Call<Post> call = placeHolderAPI.deletePost(id);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response)
            {
                if (response.isSuccessful()) {
                    Log.d("Success", "Data deleted");
                } else {
                    Log.e("Fail", "Error: " + response.code() +
                            response.message());
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
