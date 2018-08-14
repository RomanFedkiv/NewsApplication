package com.example.roman.news.cache.model

import android.arch.persistence.room.Entity
import com.example.roman.news.cache.db.dao.ConfigSearchNewsDao
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = ConfigSearchNewsDao.TABLE_NAME)
data class QueryCacheEntity (
        val query : String?,
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0
)