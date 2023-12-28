package com.example.memescasm

data class mememodel(
    val postLink: String,
    val subreddit: String,
    val title: String,
    val url: String,
    val nsfw: Boolean,
    val spoiler: Boolean,
    val author: String,
    val ups: Long,
    val preview: List<String>,
)
