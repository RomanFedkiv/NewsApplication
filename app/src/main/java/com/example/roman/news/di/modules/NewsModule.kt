package com.example.roman.news.di.modules

import com.example.roman.news.ui.NewsActivity
import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.configNews.CreateNewsConfigUseCase
import com.example.roman.news.domain.interactor.configSearch.GetSearchNewsConfigUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
import com.example.roman.news.domain.interactor.news.UpdateNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.presentation.news.NewsContract
import com.example.roman.news.presentation.news.NewsPresenter
import dagger.Module
import dagger.Provides

@Module
class NewsModule {

    @Provides
    @PerActivity
    fun provideMainView(activity: NewsActivity) = activity as NewsContract.MainView

    @Provides
    @PerActivity
    fun providePresenter(mainView: NewsContract.MainView,
                         getNewsUseCase:  GetNewsUseCase,
                         searchNewsUseCase: GetSearchUseCase,
                         getSearchNewsConfigUseCase: GetSearchNewsConfigUseCase,
                         updateNewsUseCase: UpdateNewsUseCase,
                         createNewsConfigUseCase: CreateNewsConfigUseCase) =
           NewsPresenter(mainView, getNewsUseCase, searchNewsUseCase,getSearchNewsConfigUseCase,
           updateNewsUseCase, createNewsConfigUseCase) as NewsContract.Presenter
}
