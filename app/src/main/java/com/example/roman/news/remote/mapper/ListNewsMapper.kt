package com.example.roman.news.remote.mapper

import com.example.roman.news.data.model.ListNews
import com.example.roman.news.data.model.News
import com.example.roman.news.remote.model.ListNewsRemoteEntity
import com.example.roman.news.remote.model.NewsRemoteEntity

import javax.inject.Inject

class ListNewsMapper @Inject constructor(
        private val mapper : NewsMapper
): Mapper<ListNewsRemoteEntity,ListNews>{
    override fun map(remote: ListNewsRemoteEntity) = with(remote) {
        ListNews(listNews.map { mapper.map(it) }) }
}
