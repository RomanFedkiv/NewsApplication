package com.example.roman.news.di.modules

import com.example.roman.news.ui.NewsActivity
import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.domain.interactor.config.ClearNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.GetNewsConfigUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
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
                         getNewsConfigUseCase: GetNewsConfigUseCase,
                         clearNewsConfigUseCase: ClearNewsConfigUseCase) =
           NewsPresenter(mainView, getNewsUseCase, searchNewsUseCase,getNewsConfigUseCase,
           clearNewsConfigUseCase) as NewsContract.Presenter
}
