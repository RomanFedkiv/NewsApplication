package com.example.roman.news.data

import android.util.Log
import com.example.roman.news.data.model.ListNews
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.TopHeadlinesRemote
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import io.reactivex.Single
import javax.inject.Inject


class TopHeadlinesRepositoryImpl @Inject constructor(
        private val remote : TopHeadlinesRemote
): TopHeadlinesRepository {

    override fun getTopHeadlinesNews(): Single<List<News>> =
            remote.getTopHeadlines()


}