package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import io.reactivex.Completable
import io.reactivex.Single

interface NewsConfigRepository {

    fun createConfig(configNews: NewsConfig): Completable

    fun getConfig(): Single<NewsConfig>

    fun deleteConfig(): Completable
}