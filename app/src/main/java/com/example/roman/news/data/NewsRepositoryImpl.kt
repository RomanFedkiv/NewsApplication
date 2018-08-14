package com.example.roman.news.data

import com.example.roman.news.data.repository.NewsCache
import com.example.roman.news.data.repository.NewsRemote
import com.example.roman.news.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(
        private val remote : NewsRemote,
        private val cache : NewsCache
): NewsRepository {

    override fun updateNews(country : String) = remote.getTopHeadlines(country)
            .flatMap {
                cache.clearAllNews()
                        .andThen(cache.saveNews(it))
                        .toSingle { it }
            }

    override fun getNews() = cache.getNews()
            .flatMap {
                if (it.isEmpty()) updateNews(DEFAULT_COUNTRY)
                else Single.just(it)
            }

    companion object {
        const val DEFAULT_COUNTRY = "ua"
    }
}
