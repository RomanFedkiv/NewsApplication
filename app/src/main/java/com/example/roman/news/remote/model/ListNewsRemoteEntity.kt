package com.example.roman.news.remote.model

import com.google.gson.annotations.SerializedName

data class ListNewsRemoteEntity (
        @SerializedName("articles") val listNews: List<NewsRemoteEntity>)
