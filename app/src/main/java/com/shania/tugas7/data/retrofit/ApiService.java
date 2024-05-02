package com.shania.tugas7.data.retrofit;

import com.shania.tugas7.data.response.RestaurantResponse;
import com.shania.tugas7.data.response.PostReviewResponse;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("detail/{id}")
    Call<RestaurantResponse> getRestaurant(@Path("id") String id);

    @FormUrlEncoded
    @Headers("Authorization: token 12345")
    @POST("review")
    Call<PostReviewResponse> postReview(@Field("id")String id,@Field("name")String name,@Field("review")String review);
}
