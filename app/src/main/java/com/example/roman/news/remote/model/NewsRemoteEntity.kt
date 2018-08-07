package com.example.roman.news.remote.model

import com.google.gson.annotations.SerializedName

data class NewsRemoteEntity (
        @SerializedName("title") val title: String,
        @SerializedName("urlToImage") val urlToImage: String,
        @SerializedName("publishedAt") val publishedAt: String)
