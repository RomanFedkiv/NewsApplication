package com.example.roman.news.remote

import android.util.Log
import com.example.roman.news.data.model.ListNews
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.TopHeadlinesRemote
import com.example.roman.news.remote.mapper.ListNewsMapper
import com.example.roman.news.remote.mapper.NewsMapper
import com.example.roman.news.remote.model.ListNewsRemoteEntity
import io.reactivex.Single
import javax.inject.Inject

class TopHeadlinesRemoteImpl @Inject constructor(
        private val api: NewsAPI,
        private val mapper : ListNewsMapper
) : TopHeadlinesRemote{

    override fun getTopHeadlines(): Single<List<News>> =
            api.getTopHeadlinesNews(APIConfig.COUNTRY, APIConfig.PAGE_SIZE, APIConfig.API_KEY)
                .map { it }
                .map { mapper.map(it).listNews }
}
