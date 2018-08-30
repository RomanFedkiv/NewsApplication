package com.example.roman.news.di.modules

import com.example.roman.news.ui.news.NewsActivity
import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.ui.DetailNewsActivity
import com.example.roman.news.ui.search_news.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [NewsModule::class])
    @PerActivity
    abstract fun bindNewsActivity(): NewsActivity

    @ContributesAndroidInjector(modules = [SearchModule::class])
    @PerActivity
    abstract fun bindSearchActivity(): SearchActivity

    @ContributesAndroidInjector(modules = [DetailNewsModule::class])
    @PerActivity
    abstract fun bindDetailNewsActivity(): DetailNewsActivity
}
