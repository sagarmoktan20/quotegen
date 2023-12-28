/*package com.example.newslyapiint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object newserve{
    val newsInstance:newservice
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(newservice::class.java)
    }
}*/