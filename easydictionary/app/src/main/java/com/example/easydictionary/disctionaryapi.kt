package com.example.easydictionary

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface disctionaryapi {
    @GET("en/{word}")
    suspend fun getmeaning(@Path("word") word : String) : Response<List<wordresult>>

}