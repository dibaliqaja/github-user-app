package com.dibaliqaja.githubuserapp.api

import com.dibaliqaja.githubuserapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")

    fun getSearchUsers(@Query("q") query: String): Call<UserResponse>
}