package com.example.roman.news.di

import android.app.Application
import com.example.roman.news.App
import com.example.roman.news.di.modules.APIModule
import com.example.roman.news.di.modules.ActivityBindingModule
import com.example.roman.news.di.modules.ApplicationModule
import com.example.roman.news.di.modules.CommonModule
import com.example.roman.news.di.scopes.PerApplication

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [ApplicationModule::class, ActivityBindingModule::class,
    APIModule::class, AndroidSupportInjectionModule::class, AndroidInjectionModule::class,
    CommonModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: App)
}
