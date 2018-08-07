package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import io.reactivex.Single

interface SearchNewsRepository {

    fun searchNews(query: String): Single<List<News>>
}