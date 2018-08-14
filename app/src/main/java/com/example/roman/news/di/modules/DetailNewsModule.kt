package com.example.roman.news.di.modules

import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.configNews.GetNewsConfigUseCase
import com.example.roman.news.presentation.news_detail.NewsDetailContract
import com.example.roman.news.presentation.news_detail.NewsDetailPresenter
import com.example.roman.news.ui.DetailNewsActivity
import dagger.Module
import dagger.Provides

@Module
class DetailNewsModule {

    @Provides
    @PerActivity
    fun provideMainView(activity: DetailNewsActivity) = activity as NewsDetailContract.DetailView

    @Provides
    @PerActivity
    fun providePresenter(detailView: NewsDetailContract.DetailView,
                         getNewsConfigUseCase : GetNewsConfigUseCase) =
            NewsDetailPresenter(detailView, getNewsConfigUseCase) as NewsDetailContract.Presenter
}