package com.example.roman.news.di.modules

import android.app.Application
import android.content.Context
import com.example.roman.news.data.SearchNewsRepositoryImpl
import com.example.roman.news.data.TopHeadlinesRepositoryImpl
import com.example.roman.news.data.model.ListNews
import com.example.roman.news.data.model.News
import com.example.roman.news.data.repository.SearchNewsRemote
import com.example.roman.news.data.repository.TopHeadlinesRemote
import com.example.roman.news.di.scopes.PerApplication
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.repository.SearchNewsRepository
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import com.example.roman.news.remote.NewsAPI
import com.example.roman.news.remote.SearchNewsRemoteImpl
import com.example.roman.news.remote.TopHeadlinesRemoteImpl
import com.example.roman.news.remote.mapper.ListNewsMapper
import com.example.roman.news.remote.mapper.Mapper
import com.example.roman.news.remote.mapper.NewsMapper
import com.example.roman.news.remote.model.ListNewsRemoteEntity
import com.example.roman.news.remote.model.NewsRemoteEntity
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
            mapper : ListNewsMapper
    ) = TopHeadlinesRemoteImpl(api, mapper) as TopHeadlinesRemote

    @Provides @PerApplication
    fun provideTopHeadlinesRepositoryImpl(
            remote: TopHeadlinesRemote
    ) = TopHeadlinesRepositoryImpl(remote) as TopHeadlinesRepository

    @Provides @PerApplication
    fun provideSearchNewsRemoteImpl(
            api: NewsAPI,
            mapper : ListNewsMapper
    ) = SearchNewsRemoteImpl(api, mapper) as SearchNewsRemote

    @Provides @PerApplication
    fun provideSearchNewsRepositoryImpl(
            remote: SearchNewsRemote
    ) = SearchNewsRepositoryImpl(remote) as SearchNewsRepository

    @Provides @PerApplication
    fun provideListNewsMapper(
            mapper : NewsMapper
    ) = ListNewsMapper(mapper)  as Mapper<ListNewsRemoteEntity,ListNews>
}
