package com.example.roman.news.remote.model

import com.google.gson.annotations.SerializedName

data class NewsRemoteEntity (
        @SerializedName("source") val source : SourceRemoteEntity,
        @SerializedName("title") val title: String?,
        @SerializedName("description") val description : String?,
        @SerializedName("url") val url : String?,
        @SerializedName("urlToImage") val urlToImage: String?,
        @SerializedName("publishedAt") val publishedAt: String?)
