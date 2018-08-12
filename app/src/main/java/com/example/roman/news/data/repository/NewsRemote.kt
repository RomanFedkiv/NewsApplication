package com.example.roman.news.data.repository

import com.example.roman.news.data.model.News
import io.reactivex.Single

interface NewsRemote {

    fun getTopHeadlines() : Single<List<News>>
}