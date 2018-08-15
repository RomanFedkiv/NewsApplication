package com.example.roman.news.presentation.search_news

import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.domain.interactor.configSearch.ClearSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.CreateSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.GetSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.search.GetSearchForSaerchNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.domain.interactor.utils.observable.Next
import javax.inject.Inject
import io.reactivex.Observable
import com.example.roman.news.domain.interactor.utils.completable.Complete
import com.example.roman.news.domain.interactor.utils.single.Success
import io.reactivex.internal.operators.observable.ObservableError

class SearchNewsPresenter @Inject constructor(
        private val searchView : SearchNewsContract.SearchView,
        private val searchForSaerchNewsUseCase: GetSearchForSaerchNewsUseCase,
        private val createSearchNewsConfigUseCase: CreateSearchNewsConfigUseCase,
        private val getSearchNewsConfigUseCase: GetSearchNewsConfigUseCase,
        private val clearSearchNewsConfigUseCase: ClearSearchNewsConfigUseCase,
        private val searchNewsUseCase: GetSearchUseCase
        ) : SearchNewsContract.Presenter{

    override fun start() {
        getSearchNewsConfigUseCase.execute(Unit){
            when(it) {
                is Success -> searchView.showLatestQuery(it.result)
                is Error -> searchView.showError()
            }
        }
    }

    override fun initSearch(queryObserver: Observable<String>) {
        searchForSaerchNewsUseCase.execute(queryObserver) {
            when (it) {
                is Next -> { searchView.showResultSearch(it.result) }
                is ObservableError<*> -> searchView.showError()
            }
        }
    }

    override fun createConfig(query: String?) {
        createSearchNewsConfigUseCase.execute(ConfigSearchNews(query)){
            when (it) {
                is Complete -> searchNews(query!!)
                is Error -> searchView.showError()
            }
        }
    }

    private fun searchNews(query: String) {
        searchView.showLoading()
        searchNewsUseCase.execute(query) {
            searchView.hideLoading()
            when (it) {
                is Success -> searchView.successConfigure()
                is Error -> searchView.showError()
            }
        }
    }

    override fun clearLatestQuery() {
        clearSearchNewsConfigUseCase.execute(Unit){
            when (it) {
                is Complete -> searchView.clearLatestQuery()
                is Error -> searchView.showError()
            }
        }
    }

    override fun stop() {
        searchForSaerchNewsUseCase.dispose()
    }
}