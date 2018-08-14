package com.example.roman.news.presentation.search_news

import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.BasePresenter
import com.example.roman.news.presentation.BaseView
import io.reactivex.Observable

interface SearchNewsContract {

    interface SearchView : BaseView<Presenter> {

        fun showResultSearch(listNews: List<News>)

        fun showError()

        fun successConfigure()

        fun showLatestQuery(listLatestQuery : List<ConfigSearchNews>)

        fun clearLatestQuery()
    }


    interface Presenter : BasePresenter {

        fun initSearch(queryObserver: Observable<String>)

        fun createConfig(query : String?)

        fun clearLatestQuery()
    }
}