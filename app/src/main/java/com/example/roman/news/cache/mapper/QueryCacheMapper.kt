package com.example.roman.news.cache.mapper


import com.example.roman.news.cache.model.QueryCacheEntity
import com.example.roman.news.data.model.ConfigNews
import javax.inject.Inject

class QueryCacheMapper @Inject constructor() : Mapper<QueryCacheEntity, ConfigNews>{

    override fun mapFromCache(cache: QueryCacheEntity) = with(cache) {
        ConfigNews(query)
    }

    override fun mapToCache(data: ConfigNews) = with(data) {
        QueryCacheEntity(query)
    }
}