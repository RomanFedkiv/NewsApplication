package com.example.roman.news.di.modules

import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.configSearch.ClearSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.CreateSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.GetSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.search.GetSearchForSaerchNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.presentation.search_news.SearchNewsContract
import com.example.roman.news.presentation.search_news.SearchNewsPresenter
import com.example.roman.news.ui.SearchActivity
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    @PerActivity
    fun provideSearchView(activity: SearchActivity) = activity as SearchNewsContract.SearchView

    @Provides
    @PerActivity
    fun providePresenter(mainView: SearchNewsContract.SearchView,
                         getSearchForSaerchNewsUseCase: GetSearchForSaerchNewsUseCase,
                         createSearchNewsConfigUseCase: CreateSearchNewsConfigUseCase,
                         getSearchNewsConfigUseCase: GetSearchNewsConfigUseCase,
                         clearSearchNewsConfigUseCase: ClearSearchNewsConfigUseCase,
                         searchNewsUseCase: GetSearchUseCase) =
            SearchNewsPresenter(mainView, getSearchForSaerchNewsUseCase,
                    createSearchNewsConfigUseCase,getSearchNewsConfigUseCase,clearSearchNewsConfigUseCase,
                    searchNewsUseCase) as SearchNewsContract.Presenter
}