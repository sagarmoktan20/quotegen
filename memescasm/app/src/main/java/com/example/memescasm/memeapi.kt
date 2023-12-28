package com.example.memescasm

import retrofit2.Response
import retrofit2.http.GET

interface memeapi {
    @GET("gimme/wholesomememes")
    suspend fun getmeme():Response<>
}