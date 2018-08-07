package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import io.reactivex.Single

interface TopHeadlinesRepository {

    fun getTopHeadlinesNews() : Single<List<News>>
}