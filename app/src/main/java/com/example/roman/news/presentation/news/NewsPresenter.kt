package com.example.roman.news.presentation.news

import com.example.roman.news.data.model.News
import com.example.roman.news.domain.interactor.news.GetSearchNewsUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
import com.example.roman.news.domain.interactor.utils.observable.Next
import com.example.roman.news.domain.interactor.utils.single.Success
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableError
import javax.inject.Inject

class NewsPresenter @Inject constructor(
        private val mainView : NewsContract.MainView,
        private val getNewsUseCase: GetNewsUseCase,
        private val searchNewsUseCase: GetSearchNewsUseCase
) :NewsContract.Presenter{

   override fun start() {
        getNewsUseCase.execute(Unit) {
            when(it) {
                is Success -> mainView.showNews(it.result)
                is Error -> mainView.showError()
            }

        }
    }

    override fun initSearch(queryObserver: Observable<String>) {
        searchNewsUseCase.execute(queryObserver) {
            when (it) {
                is Next -> { mainView.showSearchNews(it.result) }
                is ObservableError<*> -> mainView.showError()
            }
        }
    }

    override fun goToDetailView(news: News) {
       // detailView.initView(news)
    }

    override fun stop() {
        searchNewsUseCase.dispose()
    }

}