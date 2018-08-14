package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import io.reactivex.Single

interface NewsRepository {

    fun updateNews(country : String) : Single<List<News>>

    fun getNews() : Single<List<News>>
}