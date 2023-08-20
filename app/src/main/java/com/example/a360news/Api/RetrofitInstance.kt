package com.example.a360news.Api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object{

        val retrofit: Retrofit by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client=OkHttpClient.Builder().addInterceptor(interceptor).build()
            Retrofit.Builder().baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val api: ApiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }
    }
}