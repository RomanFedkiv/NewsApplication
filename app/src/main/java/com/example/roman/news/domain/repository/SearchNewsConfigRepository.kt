package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.ConfigSearchNews
import io.reactivex.Completable
import io.reactivex.Single

interface SearchNewsConfigRepository {

    fun createConfig(configSearch: ConfigSearchNews): Completable

    fun getConfig(): Single<List<ConfigSearchNews>>

    fun deleteConfig(): Completable
}