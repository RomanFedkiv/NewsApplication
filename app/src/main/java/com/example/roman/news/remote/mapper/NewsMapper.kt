package com.example.roman.news.remote.mapper

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.Source
import com.example.roman.news.remote.model.NewsRemoteEntity
import com.example.roman.news.remote.model.SourceRemoteEntity
import javax.inject.Inject

class NewsMapper @Inject constructor(): Mapper<NewsRemoteEntity,News>{

    override fun map(remote: NewsRemoteEntity) = with(remote) {
        News(source.name, description, title, url, urlToImage, publishedAt) }
}
