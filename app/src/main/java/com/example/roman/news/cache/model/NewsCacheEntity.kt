package com.example.roman.news.cache.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.roman.news.cache.db.dao.NewsDao
import com.google.gson.annotations.SerializedName

@Entity(tableName = NewsDao.TABLE_NAME)
data class NewsCacheEntity (
        val source : String,
        val description : String,
        val title: String,
        val url : String,
        val urlToImage: String,
        val publishedAt: String,
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0)

