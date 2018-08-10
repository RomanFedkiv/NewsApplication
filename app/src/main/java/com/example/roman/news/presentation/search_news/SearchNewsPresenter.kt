package com.example.roman.news.presentation.search_news

import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.domain.interactor.config.ClearNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.CreateNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.GetNewsConfigUseCase
import com.example.roman.news.domain.interactor.search.GetSearchForSaerchNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.domain.interactor.utils.observable.Next
import javax.inject.Inject
import io.reactivex.Observable
import com.example.roman.news.domain.interactor.utils.completable.CompletableUseCase
import com.example.roman.news.domain.interactor.utils.completable.Complete
import com.example.roman.news.domain.interactor.utils.single.Success
import io.reactivex.internal.operators.completable.CompletableError
import io.reactivex.internal.operators.observable.ObservableError

class SearchNewsPresenter @Inject constructor(
        private val searchView : SearchNewsContract.SearchView,
        private val searchForSaerchNewsUseCase: GetSearchForSaerchNewsUseCase,
        private val createNewsConfigUseCase: CreateNewsConfigUseCase,
        private val getNewsConfigUseCase: GetNewsConfigUseCase,
        private val clearNewsConfigUseCase: ClearNewsConfigUseCase
) : SearchNewsContract.Presenter{

    override fun start() {
        getNewsConfigUseCase.execute(Unit){
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
        createNewsConfigUseCase.execute(ConfigNews(query)){
            when (it) {
                is Complete -> searchView.successConfigure()
                is Error -> searchView.showError()
            }
        }
    }

    override fun clearLatestQuery() {
        clearNewsConfigUseCase.execute(Unit){
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