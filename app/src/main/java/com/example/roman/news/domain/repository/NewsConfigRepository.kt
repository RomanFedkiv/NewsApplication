package com.example.roman.news.domain.repository

import com.example.roman.news.data.model.ConfigNews
import io.reactivex.Completable
import io.reactivex.Single

interface NewsConfigRepository {

    fun createConfig(config: ConfigNews): Completable

    fun getConfig(): Single<List<ConfigNews>>

    fun deleteConfig(): Completable
}