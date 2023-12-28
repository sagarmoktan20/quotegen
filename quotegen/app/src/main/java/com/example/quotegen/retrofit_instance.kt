package com.example.quotegen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object retrofit_instance {
    private const val bas_url ="https://zenquotes.io/api/"
    private fun getinstance() :Retrofit{
        return Retrofit.Builder()
            .baseUrl(bas_url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val quoteApi:QuoteApi= getinstance().create(QuoteApi::class.java)
}