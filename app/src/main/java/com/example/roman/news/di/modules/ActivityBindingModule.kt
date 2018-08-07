package com.example.roman.news.di.modules

import com.example.roman.news.ui.DrawerActivity
import com.example.roman.news.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [TopHeadlinesModule::class])
    @PerActivity
    abstract fun bindDrawerActivity(): DrawerActivity

}
