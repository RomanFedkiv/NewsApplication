package com.example.roman.news.remote.mapper

interface Mapper<in RemoteType, out DataType> {

    fun map(remote: RemoteType): DataType
}
