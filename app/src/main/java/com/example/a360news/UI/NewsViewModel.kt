package com.example.a360news.UI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.a360news.Api.RetrofitInstance
import com.example.a360news.DataClass.Article
import com.example.a360news.DataClass.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel: ViewModel() {
    val api = "b13e655c511147ff873154b2b8ea9b0a"
    val breakingNewsliveData = MutableLiveData<List<Article>>()
   fun getbreakingNews(){

            RetrofitInstance.api.getNews("us",1,api).enqueue(object: Callback<NewsData>{

                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                   if (response.body()!=null){
                       Log.d("SEB", response.body()!!.articles.size.toString())
                       breakingNewsliveData.value= response.body()!!.articles

                   }
                    else{
                        return
                   }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    fun getCategoryNews(cat:String){
        RetrofitInstance.api.getCatNews(api,cat,"in",1).enqueue(object : Callback<NewsData>{
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {

                if (response.body()!=null){
                    Log.d("SEB", response.body()!!.articles.size.toString())
                    breakingNewsliveData.value= response.body()!!.articles

                }
                else{
                    return
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
        fun observeNewsLiveData() : LiveData<List<Article>> {
            return breakingNewsliveData


    }
}