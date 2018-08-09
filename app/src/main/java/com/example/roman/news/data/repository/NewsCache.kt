package com.example.roman.news.data.repository

import com.example.roman.news.data.model.News
import io.reactivex.Completable
import io.reactivex.Single

interface NewsCache {

    fun saveNews(news: List<News>): Completable

    fun clearAllNews(): Completable

    fun getNews(): Single<List<News>>
}