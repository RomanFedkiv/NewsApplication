package com.example.roman.news.domain

import io.reactivex.android.schedulers.AndroidSchedulers

object UIThreadFactory {

    fun get() = AndroidSchedulers.mainThread()
}
