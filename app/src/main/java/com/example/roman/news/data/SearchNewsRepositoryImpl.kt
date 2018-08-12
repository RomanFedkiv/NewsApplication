package com.example.roman.news.data

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.data.repository.ConfigNewsCache
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
        private val remote: SearchNewsRemote,
        private val cache : ConfigNewsCache
) : SearchNewsRepository {

    override fun insertLatestQuery(query: ConfigNews) {
        cache.saveNews(query)
    }

    override fun getLatestsQuery(): Single<List<ConfigNews>> = cache.getNews()

    override fun searchNews(query: String): Single<List<News>> {
        cache.saveNews(ConfigNews(query))
        return remote.searchNews(query)
    }

    override fun searchNewsForNewsInput(query: String) = remote.searchNews(query)

}