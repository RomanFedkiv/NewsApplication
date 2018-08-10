package com.example.roman.news.data.repository

import com.example.roman.news.data.model.ConfigNews
import io.reactivex.Completable
import io.reactivex.Single

interface ConfigNewsCache {

    fun saveNews(query : ConfigNews): Completable

    fun clearAllNews(): Completable

    fun getNews(): Single<List<ConfigNews>>
}