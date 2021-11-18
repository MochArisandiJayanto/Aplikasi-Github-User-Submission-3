package com.mrjaya.fundamentalkotlinsubmission3.api

import com.mrjaya.fundamentalkotlinsubmission3.model.DetailResponse
import com.mrjaya.fundamentalkotlinsubmission3.model.ItemsItem
import com.mrjaya.fundamentalkotlinsubmission3.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>
}