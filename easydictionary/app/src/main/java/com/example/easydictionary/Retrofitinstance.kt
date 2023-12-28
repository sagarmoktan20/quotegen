package com.example.easydictionary

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {

    private const val baseurl="https://api.dictionaryapi.dev/api/v2/entries/"

    private fun getinstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
    val Dictionaryapi:disctionaryapi= getinstance().create(disctionaryapi::class.java)
}