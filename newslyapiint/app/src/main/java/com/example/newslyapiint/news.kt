package com.example.newslyapiint

data class news(
    val status: String,
    val totalResults: Long,
    val articles: List<article>,
)