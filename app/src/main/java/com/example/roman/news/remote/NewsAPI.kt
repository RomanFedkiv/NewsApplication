package com.example.roman.news.remote

import com.example.roman.news.remote.model.ListNewsRemoteEntity
import com.example.roman.news.remote.model.NewsRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    fun getTopHeadlinesNews(@Query("country") country: String, @Query("pageSize") pageSize: Int,
                            @Query("apiKey") apiKey:String)
            : Single<ListNewsRemoteEntity>

    @GET("everything")
    fun searchNews(@Query("q") query: String, @Query("apiKey") apiKey:String)
            : Single<ListNewsRemoteEntity>


}
