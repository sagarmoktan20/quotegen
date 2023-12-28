package com.example.newslyapiint

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/everything?q=apple&from=2023-12-23&to=2023-12-23&sortBy=popularity&apiKey=eb403379e58d4b2c92eba8b8b85cf2a9
//https://newsapi.org/v2/top-headlines?country=us&apiKey=eb403379e58d4b2c92eba8b8b85cf2a9
const val base_url="https://newsapi.org//"
const val api_key="eb403379e58d4b2c92eba8b8b85cf2a9"
interface newservice {

    @GET("v2/top-headlines?apiKey=$api_key")
    fun getheadlines(@Query("country")country:String, @Query("page") pages:Int): retrofit2.Call<news>
}
object newserve{
    val newsInstance:newservice
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
newsInstance=retrofit.create(newservice::class.java)
    }
}