package com.example.roman.news.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.roman.news.cache.db.converter.ListConverter
import com.example.roman.news.cache.db.dao.ConfigNewsDao
import com.example.roman.news.cache.db.dao.ConfigSearchNewsDao
import com.example.roman.news.cache.db.dao.NewsDao
import com.example.roman.news.cache.model.NewsCacheEntity
import com.example.roman.news.cache.model.NewsConfigCacheEntity
import com.example.roman.news.cache.model.QueryCacheEntity

@Database(entities = [
    NewsCacheEntity::class,
    QueryCacheEntity::class,
    NewsConfigCacheEntity::class
], version = 1)
@TypeConverters(value = [ListConverter::class])
abstract class AppDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    abstract fun configNewsSearchDao(): ConfigSearchNewsDao

    abstract fun configNewsDao() : ConfigNewsDao

}