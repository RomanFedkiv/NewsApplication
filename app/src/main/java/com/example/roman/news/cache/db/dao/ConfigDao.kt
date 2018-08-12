package com.example.roman.news.cache.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.roman.news.cache.model.QueryCacheEntity

@Dao
interface ConfigDao {

    companion object {
        const val TABLE_NAME = "query"
    }

    @Insert
    fun insertQuery(lessons: QueryCacheEntity)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<QueryCacheEntity>
}