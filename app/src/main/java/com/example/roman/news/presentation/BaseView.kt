package com.example.roman.news.presentation

interface BaseView<P : BasePresenter> {

    var presenter: P
}
