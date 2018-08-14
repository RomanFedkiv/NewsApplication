package com.example.roman.news.data.repository

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import io.reactivex.Completable
import io.reactivex.Single

interface ConfigNewsCache {

    fun saveNews(news : NewsConfig): Completable

    fun clearAllNews(): Completable

    fun getNews(): Single<NewsConfig>
}