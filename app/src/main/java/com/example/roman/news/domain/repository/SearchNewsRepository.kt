package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.ConfigNews
import io.reactivex.Single

interface SearchNewsRepository {

    fun searchNewsForNewsInput(query: String): Single<List<News>>

    fun searchNews(query: String): Single<List<News>>

    fun insertLatestQuery(query: ConfigNews)

    fun getLatestsQuery() : Single<List<ConfigNews>>
}