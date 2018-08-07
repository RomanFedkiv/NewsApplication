package com.example.roman.news.presentation.topHeadlines

import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.BasePresenter
import com.example.roman.news.presentation.BaseView
import io.reactivex.Observable


interface TopHeadlinesContract {

    interface View : BaseView<Presenter> {

        fun showNews(listNews : List<News>)

        fun showError()

        fun showSearchNews(listNews: List<News>)
    }

    interface Presenter : BasePresenter {

        fun initSearch(queryObserver: Observable<String>)
    }
}