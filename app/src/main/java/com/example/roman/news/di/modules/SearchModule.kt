package com.example.roman.news.di.modules

import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.config.ClearNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.CreateNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.GetNewsConfigUseCase
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
                         createNewsConfigUseCase: CreateNewsConfigUseCase,
                         getNewsConfigUseCase: GetNewsConfigUseCase,
                         clearNewsConfigUseCase: ClearNewsConfigUseCase) =
            SearchNewsPresenter(mainView, getSearchForSaerchNewsUseCase,
                    createNewsConfigUseCase,getNewsConfigUseCase,clearNewsConfigUseCase) as SearchNewsContract.Presenter
}