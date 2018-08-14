package com.example.roman.news.data

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.data.repository.ConfigNewsCache
import com.example.roman.news.domain.repository.NewsConfigRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class NewsConfigRepositoryImpl @Inject constructor(
        private val cacheNewsConfig: ConfigNewsCache
) : NewsConfigRepository {

    override fun createConfig(configNews: NewsConfig) = cacheNewsConfig.saveNews(configNews)

    override fun getConfig() = cacheNewsConfig.getNews()

    override fun deleteConfig() = cacheNewsConfig.clearAllNews()

}