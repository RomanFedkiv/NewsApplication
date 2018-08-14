package com.example.roman.news.presentation.news

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.presentation.BasePresenter
import com.example.roman.news.presentation.BaseView
import io.reactivex.Observable


interface NewsContract {

    interface MainView : BaseView<Presenter> {

        fun showNews(listNews: List<News>)

        fun showError()

        fun successConfigure()
    }


    interface Presenter : BasePresenter {

        fun createNewsConfig(news : NewsConfig)

        fun updateTopHeadlines(country : String)
    }
}