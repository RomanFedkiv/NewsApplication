package com.example.roman.news.di.modules

import com.example.roman.news.ui.NewsActivity
import com.example.roman.news.di.scopes.PerActivity
import com.example.roman.news.ui.DetailNewsActivity
import dagger.Module
import dagger.Subcomponent
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [NewsModule::class])
    @PerActivity
    abstract fun bindDrawerActivity(): NewsActivity

}
