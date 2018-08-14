package com.example.roman.news.cache.mapper


import com.example.roman.news.cache.model.QueryCacheEntity
import com.example.roman.news.data.model.ConfigSearchNews
import javax.inject.Inject

class QueryCacheMapper @Inject constructor() : Mapper<QueryCacheEntity, ConfigSearchNews>{

    override fun mapFromCache(cache: QueryCacheEntity) = with(cache) {
        ConfigSearchNews(query)
    }

    override fun mapToCache(data: ConfigSearchNews) = with(data) {
        QueryCacheEntity(query)
    }
}