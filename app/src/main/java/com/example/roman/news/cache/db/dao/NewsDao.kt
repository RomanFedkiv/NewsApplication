package com.example.roman.news.cache.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.roman.news.cache.model.NewsCacheEntity

@Dao
interface NewsDao {

    companion object {
        const val TABLE_NAME = "news"
    }

    @Insert
    fun insert(vararg news: NewsCacheEntity)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<NewsCacheEntity>

}