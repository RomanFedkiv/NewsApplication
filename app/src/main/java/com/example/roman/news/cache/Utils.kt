package com.example.roman.news.cache

import io.reactivex.Completable
import io.reactivex.Single

fun completableCall(action: () -> Unit) = Completable.create {
    try {
        action()
        it.onComplete()
    } catch (t: Throwable) {
        it.onError(t)
    }
}

fun <T> singleCall(action: () -> T) = Single.create<T> {
    try {
        val result = action()
        it.onSuccess(result)
    } catch (t: Throwable) {
        it.onError(t)
    }
}