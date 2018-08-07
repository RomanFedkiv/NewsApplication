package com.example.roman.news.presentation.topHeadlines

import android.util.Log
import com.example.roman.news.domain.interactor.topHeadlines.GetSearchNewsUseCase
import com.example.roman.news.domain.interactor.topHeadlines.GetTopHeadlinesUseCase
import com.example.roman.news.domain.interactor.utils.observable.Next
import com.example.roman.news.domain.interactor.utils.single.Success
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableError
import javax.inject.Inject

class TopHeadlinesPresenter @Inject constructor(
        private val view : TopHeadlinesContract.View,
        private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
        private val searchNewsUseCase: GetSearchNewsUseCase
) :TopHeadlinesContract.Presenter{

    override fun start() {
        getTopHeadlinesUseCase.execute(Unit) {

            when(it) {
                is Success -> view.showNews(it.result)
                is Error -> view.showError()
            }
        }
    }

    override fun initSearch(queryObserver: Observable<String>) {

        //queryObserver.doOnTerminate { view.showLoading() }
        searchNewsUseCase.execute(queryObserver) {
           // view.hideLoading()
            when (it) {
                is Next -> {
                    it.result.forEach {
                        Log.i("boom", it.title)
                    }
                    view.showSearchNews(it.result)
                }
                is ObservableError<*> -> view.showError()
            }
        }
    }

    override fun stop() {
        searchNewsUseCase.dispose()
    }

}