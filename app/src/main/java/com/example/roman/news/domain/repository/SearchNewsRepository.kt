package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.ConfigSearchNews
import io.reactivex.Single

interface SearchNewsRepository {

    fun searchNewsForNewsInput(query: String): Single<List<News>>

    fun searchNews(query: String): Single<List<News>>

    fun insertLatestQuery(query: ConfigSearchNews)

    fun getLatestsQuery() : Single<List<ConfigSearchNews>>
}