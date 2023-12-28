package com.example.newslyapiint

import android.icu.text.CaseMap.Title

data class article(
   // val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
)