package com.example.roman.news.cache

import android.util.Log
import com.example.roman.news.cache.db.dao.NewsDao
import com.example.roman.news.cache.mapper.NewsCacheMapper
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.NewsCache
import javax.inject.Inject

class NewsCacheImpl @Inject constructor(
        private val newsDao: NewsDao,
        private val mapper: NewsCacheMapper
) : NewsCache {

    override fun saveNews(news: List<News>) = completableCall {
        val data = news.map(mapper::mapToCache).toTypedArray()

        newsDao.insert(*data)
    }

    override fun clearAllNews() = completableCall {
        newsDao.deleteAll()
    }

    override fun getNews() = singleCall {
        newsDao.getAll().map(mapper::mapFromCache)
    }
}