package com.example.roman.news.remote.mapper

import com.example.roman.news.data.model.News
import com.example.roman.news.remote.model.NewsRemoteEntity
import javax.inject.Inject

class NewsMapper @Inject constructor(): Mapper<NewsRemoteEntity,News>{

    override fun map(remote: NewsRemoteEntity) = with(remote) {
       News(title,urlToImage,publishedAt) }
}
