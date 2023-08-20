package com.example.a360news.Api

import com.example.a360news.DataClass.NewsData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/top-headlines")
    fun getNews(
        @Query("country")
        country :String = "us",
        @Query("page")
        page : Int=1,
        @Query("apiKey")
        apiKey: String = "b13e655c511147ff873154b2b8ea9b0a"
        ): Call<NewsData>


    @GET("v2/top-headlines")
    fun getCatNews(
        @Query("apiKey")
        apiKey: String = "b13e655c511147ff873154b2b8ea9b0a",
        @Query("category")
        category : String,
        @Query("country")
        country :String = "in",
        @Query("page")
        page : Int=1
    ): Call<NewsData>

}