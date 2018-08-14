package com.example.roman.news.cache.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.roman.news.cache.model.NewsCacheEntity
import com.example.roman.news.cache.model.NewsConfigCacheEntity

@Dao
interface ConfigNewsDao {

    companion object {
        const val TABLE_NAME = "newsConfig"
    }

    @Insert
    fun insertConfigNews(news: NewsConfigCacheEntity)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteConfigNews()

    @Query("SELECT * FROM $TABLE_NAME LIMIT 1")
    fun getConfigNews(): NewsConfigCacheEntity
}