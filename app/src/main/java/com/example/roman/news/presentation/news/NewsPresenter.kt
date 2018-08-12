package com.example.roman.news.presentation.news

import android.util.Log
import com.example.roman.news.domain.interactor.config.ClearNewsConfigUseCase
import com.example.roman.news.domain.interactor.config.GetNewsConfigUseCase
import com.example.roman.news.domain.interactor.news.GetNewsUseCase
import com.example.roman.news.domain.interactor.search.GetSearchUseCase
import com.example.roman.news.domain.interactor.utils.observable.Next
import com.example.roman.news.domain.interactor.utils.single.Success
import io.reactivex.internal.operators.observable.ObservableError
import javax.inject.Inject

class NewsPresenter @Inject constructor(
        private val mainView : NewsContract.MainView,
        private val getNewsUseCase: GetNewsUseCase,
        private val searchNewsUseCase: GetSearchUseCase,
        private val getNewsConfigUseCase: GetNewsConfigUseCase,
        private val clearNewsConfigUseCase: ClearNewsConfigUseCase
) :NewsContract.Presenter{

    override fun start() {
      /* getNewsConfigUseCase.execute(Unit) {
           when (it) {
               is Success -> searchNewsUseCase.execute(it.result.get(it.result.lastIndex).query!!){
                   when (it) {
                       is Success -> mainView.showNews(it.result)
                       is Error -> mainView.showError()
                   }
               }
               is Error -> mainView.showError()
           }
       }*/
getTop()
    }

    override fun clearConfig() {
        clearNewsConfigUseCase.execute(Unit){
            when(it){

            }
        }
    }

    private fun getTop() {
        getNewsUseCase.execute(Unit) {
            when(it) {
                is Success -> mainView.showNews(it.result)
                is Error -> mainView.showError()
            }
        }
    }
    override fun stop() {
        getNewsUseCase.dispose()
    }

}