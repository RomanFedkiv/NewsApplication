package com.example.roman.news.presentation.news

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.domain.interactor.configNews.CreateNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.GetSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
import com.example.roman.news.domain.interactor.news.UpdateNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.domain.interactor.utils.completable.Complete
import com.example.roman.news.domain.interactor.utils.single.Success
import javax.inject.Inject

class NewsPresenter @Inject constructor(
        private val mainView : NewsContract.MainView,
        private val getNewsUseCase: GetNewsUseCase,
        private val searchNewsUseCase: GetSearchUseCase,
        private val getSearchNewsConfigUseCase: GetSearchNewsConfigUseCase,
        private val updateNewsUseCase: UpdateNewsUseCase,
        private val createNewsConfigUseCase: CreateNewsConfigUseCase
) :NewsContract.Presenter{

    override fun start() {
       getSearchNewsConfigUseCase.execute(Unit) {
           when (it) {
               is Success ->
                   if (it.result.isEmpty()) {
                       getTop()
                   }
               else
                   searchNewsUseCase.execute(it.result.get(it.result.lastIndex).query!!){
                   when (it) {
                       is Success -> mainView.showNews(it.result)
                       is Error -> getTop()
                   }
               }
               is Error -> mainView.showError()
           }
       }
    }

    override fun updateTopHeadlines(country : String) {
        updateNewsUseCase.execute(country) {
            when (it) {
                is Success -> mainView.showNews(it.result)
                is Error -> mainView.showError()
            }
        }
    }

    override fun createNewsConfig(news: NewsConfig) {
        createNewsConfigUseCase.execute(news){
            when (it) {
                is Complete -> mainView.successConfigure()
                is Error -> mainView.showError()
            }
        }
    }

    private fun getTop() {
        getNewsUseCase.execute(Unit) {
            when(it) {
                is Success -> mainView.showNews(it.result)
                is Error -> mainView.showError()
            }
        }
    }
    override fun stop() {
        getNewsUseCase.dispose()
    }

}