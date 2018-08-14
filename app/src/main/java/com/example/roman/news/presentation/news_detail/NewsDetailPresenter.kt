package com.example.roman.news.presentation.news_detail

import com.example.roman.news.domain.interactor.configNews.GetNewsConfigUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
import com.example.roman.news.domain.interactor.utils.single.Success
import javax.inject.Inject

class NewsDetailPresenter  @Inject constructor(
        private val detailView : NewsDetailContract.DetailView,
        private val getNewsConfigUseCase : GetNewsConfigUseCase
) :NewsDetailContract.Presenter{

    override fun start() {
        getNewsConfigUseCase.execute(Unit){
            when(it) {
                is Success -> detailView.showDetailNews(it.result)
                is Error -> detailView.showError()
            }
        }
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}