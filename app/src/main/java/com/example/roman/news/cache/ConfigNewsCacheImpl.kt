package com.example.roman.news.cache

import android.util.Log
import com.example.roman.news.cache.db.dao.ConfigNewsDao
import com.example.roman.news.cache.mapper.NewsConfigCacheMapper
import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.data.repository.ConfigNewsCache
import javax.inject.Inject

class ConfigNewsCacheImpl @Inject constructor(
        private val configNewsDao: ConfigNewsDao,
        private val mapper: NewsConfigCacheMapper
) : ConfigNewsCache {

    override fun saveNews(news : NewsConfig) = completableCall {
        configNewsDao.deleteConfigNews()
        val data = mapper.mapToCache(news)
        configNewsDao.insertConfigNews(data)
    }

    override fun clearAllNews() = completableCall {
        configNewsDao.deleteConfigNews()
    }

    override fun getNews() = singleCall {
        mapper.mapFromCache(configNewsDao.getConfigNews())
    }
}