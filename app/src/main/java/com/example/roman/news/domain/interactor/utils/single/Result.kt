package com.example.roman.news.domain.interactor.utils.single

sealed class Result<T>

data class Success<T>(val result: T) : Result<T>()

data class Error<T>(val e: Throwable) : Result<T>()
