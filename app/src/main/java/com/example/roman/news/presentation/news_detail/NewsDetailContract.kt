package com.example.roman.news.presentation.news_detail

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.presentation.BasePresenter
import com.example.roman.news.presentation.BaseView
import io.reactivex.Observable

class NewsDetailContract {

    interface DetailView : BaseView<Presenter> {
        fun showDetailNews(news : NewsConfig)

        fun showError()

    }


    interface Presenter : BasePresenter {


    }
}