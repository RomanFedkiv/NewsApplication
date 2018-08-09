package com.example.roman.news.data

import com.example.roman.news.data.repository.NewsCache
import com.example.roman.news.data.repository.NewsRemote
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import io.reactivex.Single
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(
        private val remote : NewsRemote,
        private val cache : NewsCache
): TopHeadlinesRepository {

    override fun updateNews() = remote.getTopHeadlines()
            .flatMap {
                cache.clearAllNews()
                        .andThen(cache.saveNews(it))
                        .toSingle { it }
            }

    override fun getNews() = cache.getNews()
            .flatMap {
                if (it.isEmpty()) updateNews()
                else Single.just(it)
            }
}
