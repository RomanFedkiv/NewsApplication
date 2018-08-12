package com.example.roman.news.cache

import android.util.Log
import com.example.roman.news.cache.db.dao.ConfigDao
import com.example.roman.news.cache.mapper.QueryCacheMapper
import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.data.repository.ConfigNewsCache
import javax.inject.Inject

class ConfigNewsCacheImpl @Inject constructor(
        private val configDao: ConfigDao,
        private val mapper: QueryCacheMapper
) : ConfigNewsCache {

    override fun saveNews(query: ConfigNews) = completableCall {
        Log.i("asd: ",query.query)
        configDao.insertQuery(mapper.mapToCache(query))
    }

    override fun clearAllNews() = completableCall {
        configDao.deleteAll()
    }

    override fun getNews() = singleCall {
        configDao.getAll().forEach {
            Log.i("dsa", it.query + ",")
        }
        configDao.getAll().map(mapper::mapFromCache)
    }
}