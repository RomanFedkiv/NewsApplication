package com.example.roman.news.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.roman.news.cache.db.converter.ListConverter
import com.example.roman.news.cache.db.dao.NewsDao
import com.example.roman.news.cache.model.NewsCacheEntity

@Database(entities = [
    NewsCacheEntity::class
], version = 1)
@TypeConverters(value = [ListConverter::class])
abstract class AppDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

}