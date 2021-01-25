package com.motatawera.postsapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.motatawera.postsapi.R;
import com.motatawera.postsapi.model.Posts;
import com.motatawera.postsapi.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = findViewById(R.id.post_title);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Posts> call = apiInterface.getpost();

        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                title.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                title.setText(t.getMessage());
            }
        });


    }
}