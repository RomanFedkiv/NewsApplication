package com.example.roman.news.cache.mapper

interface Mapper<CacheType, DataType> {

    fun mapFromCache(cache: CacheType): DataType

    fun mapToCache(data: DataType): CacheType
}
