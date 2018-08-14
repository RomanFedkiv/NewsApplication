package com.example.roman.news.data

import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.repository.ConfigSearchNewsCache
import com.example.roman.news.domain.repository.SearchNewsConfigRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsConfigRepositoryImpl @Inject constructor(
        private val cacheSearch: ConfigSearchNewsCache
) : SearchNewsConfigRepository {

    override fun createConfig(configSearch: ConfigSearchNews) = cacheSearch.saveNews(configSearch)

    override fun getConfig(): Single<List<ConfigSearchNews>> = cacheSearch.getNews()

    override fun deleteConfig() = cacheSearch.clearAllNews()

}