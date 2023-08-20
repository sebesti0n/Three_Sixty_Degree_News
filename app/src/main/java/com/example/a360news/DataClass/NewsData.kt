package com.example.a360news.DataClass

data class NewsData(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)