package com.example.roman.news.remote

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.NewsRemote
import com.example.roman.news.remote.mapper.Mapper
import com.example.roman.news.remote.model.NewsRemoteEntity
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteImpl @Inject constructor(
        private val api: NewsAPI,
        private val mapper : Mapper<NewsRemoteEntity, News>
) : NewsRemote{

    override fun getTopHeadlines(): Single<List<News>> =
            api.getTopHeadlinesNews(APIConfig.COUNTRY, APIConfig.PAGE_SIZE, APIConfig.API_KEY)
                    .map {it.data.forEach {
                        Log.i("remote",it.title + ",")
                    }
                        it.data}
                    .map {it.map(mapper::map) } }
