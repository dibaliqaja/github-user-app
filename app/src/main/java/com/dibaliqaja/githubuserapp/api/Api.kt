package com.dibaliqaja.githubuserapp.api

import com.dibaliqaja.githubuserapp.data.model.DetailUserResponse
import com.dibaliqaja.githubuserapp.data.model.User
import com.dibaliqaja.githubuserapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(@Query("q") query: String): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(@Path("username") username: String): Call<DetailUserResponse>

    @GET("users/{username}/follower")
    @Headers("Authorization: token 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")
    fun getFollowers(@Path("username") username: String): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(@Path("username") username: String): Call<ArrayList<User>>
}