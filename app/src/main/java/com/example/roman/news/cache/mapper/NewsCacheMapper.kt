package com.example.roman.news.cache.mapper

import com.example.roman.news.cache.model.NewsCacheEntity
import com.example.roman.news.data.model.News
import javax.inject.Inject

class NewsCacheMapper @Inject constructor() : Mapper<NewsCacheEntity, News> {

    override fun mapFromCache(cache: NewsCacheEntity) = with(cache) {
        News(source,description,title,url,urlToImage,publishedAt)
    }

    override fun mapToCache(data: News) = with(data) {
        NewsCacheEntity(source,description,title,url,urlToImage,publishedAt)
    }
}