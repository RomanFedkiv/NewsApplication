package com.example.roman.news.data

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
        private val remote: SearchNewsRemote
) : SearchNewsRepository {

    override fun searchNews(query: String) = remote.searchNews(query)
}