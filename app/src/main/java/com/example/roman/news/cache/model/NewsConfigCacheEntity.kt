package com.example.roman.news.cache.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.roman.news.cache.db.dao.ConfigNewsDao

@Entity(tableName = ConfigNewsDao.TABLE_NAME)
data class NewsConfigCacheEntity (
        val source : String?,
        val description : String?,
        val title: String?,
        val url : String?,
        val urlToImage: String?,
        val publishedAt: String?,
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0)