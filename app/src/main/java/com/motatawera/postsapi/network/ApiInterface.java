package com.motatawera.postsapi.network;

import com.motatawera.postsapi.model.Posts;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("posts/1")
    Call<Posts> getpost();

}
