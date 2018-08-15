package com.example.roman.news.data

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.repository.ConfigSearchNewsCache
import com.example.roman.news.data.repository.NewsCache
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
        private val remote: SearchNewsRemote,
        private val cacheSearch : ConfigSearchNewsCache,
        private val cacheNews : NewsCache
) : SearchNewsRepository {

    override fun insertLatestQuery(query: ConfigSearchNews) {
        cacheSearch.saveNews(query)
    }

    override fun getLatestsQuery(): Single<List<ConfigSearchNews>> = cacheSearch.getNews()

    override fun searchNews(query: String) = remote.searchNews(query)
            .flatMap {
                cacheNews.clearAllNews()
                        .andThen(cacheNews.saveNews(it))
                        .toSingle { it }
            }


    override fun searchNewsForNewsInput(query: String) = remote.searchNews(query)

}