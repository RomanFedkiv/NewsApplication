package com.example.roman.news.data

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.repository.ConfigSearchNewsCache
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
        private val remote: SearchNewsRemote,
        private val cacheSearch : ConfigSearchNewsCache
) : SearchNewsRepository {

    override fun insertLatestQuery(query: ConfigSearchNews) {
        cacheSearch.saveNews(query)
    }

    override fun getLatestsQuery(): Single<List<ConfigSearchNews>> = cacheSearch.getNews()

    override fun searchNews(query: String): Single<List<News>> {
        cacheSearch.saveNews(ConfigSearchNews(query))
        return remote.searchNews(query)
    }

    override fun searchNewsForNewsInput(query: String) = remote.searchNews(query)

}