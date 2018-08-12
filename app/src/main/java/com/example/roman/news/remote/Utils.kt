package com.example.roman.news.remote

import com.google.gson.annotations.SerializedName

data class Responce<T>(
        @SerializedName("articles") val data: T)

