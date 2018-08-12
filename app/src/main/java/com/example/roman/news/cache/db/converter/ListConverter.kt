package com.example.roman.news.cache.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {

    private val gson = Gson()

    @TypeConverter
    fun toList(data: String): List<Long> {
        val type = object : TypeToken<List<Long>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromList(list: List<Long>) = gson.toJson(list)
}