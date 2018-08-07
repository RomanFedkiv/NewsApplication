package com.example.roman.news.domain

import io.reactivex.schedulers.Schedulers

object IOThreadFactory {

    fun get() = Schedulers.io()
}
