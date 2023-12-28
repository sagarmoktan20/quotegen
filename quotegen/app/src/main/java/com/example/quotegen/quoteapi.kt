package com.example.quotegen

import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {
    @GET("random")
    suspend fun getRandomQuote(): Response<List<quotemodel>>
}
