package com.example.roman.news.data

import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.data.repository.ConfigNewsCache
import com.example.roman.news.domain.repository.NewsConfigRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class NewsConfigRepositoryImpl @Inject constructor(
        private val cache: ConfigNewsCache
) : NewsConfigRepository {

    override fun createConfig(config: ConfigNews) = cache.saveNews(config)

    override fun getConfig(): Single<List<ConfigNews>> = cache.getNews()

    override fun deleteConfig() = cache.clearAllNews()

}