package com.example.roman.news.cache.mapper

import com.example.roman.news.cache.model.NewsConfigCacheEntity
import com.example.roman.news.data.model.NewsConfig
import javax.inject.Inject

class NewsConfigCacheMapper @Inject constructor() : Mapper<NewsConfigCacheEntity, NewsConfig> {

    override fun mapFromCache(cache: NewsConfigCacheEntity) = with(cache) {
        NewsConfig(source, description, title, url, urlToImage, publishedAt)
    }

    override fun mapToCache(data: NewsConfig) = with(data) {
        NewsConfigCacheEntity(source, description, title, url, urlToImage, publishedAt)
    }
}