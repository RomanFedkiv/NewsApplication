package com.example.roman.news.remote

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.remote.mapper.NewsMapper
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsRemoteImpl @Inject constructor(
        private val api: NewsAPI,
        private val mapper: NewsMapper
) : SearchNewsRemote {

    override fun searchNews(query: String): Single<List<News>> =
        api.searchNews(query, APIConfig.API_KEY)
                .map { it.data }
                .map { it.map(mapper::map) }
}