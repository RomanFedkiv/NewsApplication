package com.example.roman.news.cache.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.roman.news.cache.model.QueryCacheEntity

@Dao
interface ConfigSearchNewsDao {

    companion object {
        const val TABLE_NAME = "query"
    }

    @Insert
    fun insertQuery(query: QueryCacheEntity)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()

    @Query("DELETE FROM $TABLE_NAME WHERE query = :title")
    fun deleteByTitle(title : String)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<QueryCacheEntity>
}