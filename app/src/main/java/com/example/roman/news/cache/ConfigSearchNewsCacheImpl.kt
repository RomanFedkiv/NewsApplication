package com.example.roman.news.cache

import com.example.roman.news.cache.db.dao.ConfigSearchNewsDao
import com.example.roman.news.cache.mapper.QueryCacheMapper
import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.repository.ConfigSearchNewsCache
import io.reactivex.Completable
import javax.inject.Inject

class ConfigSearchNewsCacheImpl @Inject constructor(
        private val configSearchNewsDao: ConfigSearchNewsDao,
        private val mapper: QueryCacheMapper
) : ConfigSearchNewsCache {

    override fun saveNews(query: ConfigSearchNews) = completableCall {
        configSearchNewsDao.insertQuery(mapper.mapToCache(query))
    }

    override fun clearAllNews() = completableCall {
        configSearchNewsDao.deleteAll()
    }

    override fun clearQueryByTitle(query: String) = completableCall {
        configSearchNewsDao.deleteByTitle(query)
    }

    override fun getNews() = singleCall {
        configSearchNewsDao.getAll().map(mapper::mapFromCache)
    }
}