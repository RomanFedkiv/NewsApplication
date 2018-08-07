package com.example.roman.news.di.modules

import com.example.roman.news.ui.DrawerActivity
import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.topHeadlines.GetSearchNewsUseCase
import com.example.roman.news.domain.interactor.topHeadlines.GetTopHeadlinesUseCase
import com.example.roman.news.presentation.topHeadlines.TopHeadlinesContract
import com.example.roman.news.presentation.topHeadlines.TopHeadlinesPresenter
import dagger.Module
import dagger.Provides

@Module
class TopHeadlinesModule {

    @Provides
    @PerActivity
    fun provideView(activity: DrawerActivity) = activity as TopHeadlinesContract.View

    @Provides
    @PerActivity
    fun providePresenter(view: TopHeadlinesContract.View,
                         getTopHeadlinesUseCase:  GetTopHeadlinesUseCase,
                         searchNewsUseCase: GetSearchNewsUseCase) =
           TopHeadlinesPresenter(view, getTopHeadlinesUseCase, searchNewsUseCase) as TopHeadlinesContract.Presenter
}