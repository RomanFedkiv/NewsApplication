package com.example.roman.news.data.repository

import com.example.roman.news.data.model.ConfigSearchNews
import io.reactivex.Completable
import io.reactivex.Single

interface ConfigSearchNewsCache {

    fun saveNews(query : ConfigSearchNews): Completable

    fun clearAllNews(): Completable

    fun clearQueryByTitle(query : String) : Completable

    fun getNews(): Single<List<ConfigSearchNews>>
}