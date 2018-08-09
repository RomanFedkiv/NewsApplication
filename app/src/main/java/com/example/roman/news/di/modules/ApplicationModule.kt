package com.example.roman.news.di.modules

import android.app.Application
import android.content.Context
import com.example.roman.news.cache.NewsCacheImpl
import com.example.roman.news.cache.db.dao.NewsDao
import com.example.roman.news.cache.mapper.NewsCacheMapper
import com.example.roman.news.data.SearchNewsRepositoryImpl
import com.example.roman.news.data.NewsRepositoryImpl
import com.example.roman.news.data.repository.NewsCache
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.data.repository.NewsRemote
import com.example.roman.news.di.scopes.PerApplication
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.repository.SearchNewsRepository
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import com.example.roman.news.remote.NewsAPI
import com.example.roman.news.remote.SearchNewsRemoteImpl
import com.example.roman.news.remote.NewsRemoteImpl
import com.example.roman.news.remote.mapper.NewsMapper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides @PerApplication
    fun provideContext(application: Application) = application as Context

    @Provides @PerApplication
    fun provideIOThreadFactory() = IOThreadFactory

    @Provides @PerApplication
    fun provideUIThreadFactory() = UIThreadFactory

    @Provides @PerApplication
    fun provideTopHeadlinesRemoteImpl(
            api: NewsAPI,
            mapper : NewsMapper
    ) = NewsRemoteImpl(api, mapper) as NewsRemote

    @Provides @PerApplication
    fun provideTopHeadlinesRepositoryImpl(
            remote: NewsRemote,
            cache : NewsCache
    ) = NewsRepositoryImpl(remote,cache) as TopHeadlinesRepository

    @Provides @PerApplication
    fun provideSearchNewsRemoteImpl(
            api: NewsAPI,
            mapper : NewsMapper
    ) = SearchNewsRemoteImpl(api, mapper) as SearchNewsRemote

    @Provides @PerApplication
    fun provideSearchNewsRepositoryImpl(
            remote: SearchNewsRemote
    ) = SearchNewsRepositoryImpl(remote) as SearchNewsRepository

    @Provides @PerApplication
    fun provideNewsCacheImpl(
            newsDao: NewsDao,
            mapper: NewsCacheMapper
    ) = NewsCacheImpl(newsDao,mapper) as NewsCache

}
