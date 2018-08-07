package com.example.roman.news.domain.interactor.topHeadlines

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.domain.interactor.utils.observable.ObservableUseCase
import io.reactivex.Observable
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import retrofit2.HttpException
import java.io.InterruptedIOException
import javax.inject.Inject

class GetSearchNewsUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val searchRepository: SearchNewsRepository
) : ObservableUseCase<List<News>, Observable<String>>(io, ui) {

    override fun buildUseCase(param: Observable<String>) = param
            .flatMapSingle {
                Log.i("query3", it)
                searchRepository.searchNews(it)
                        .onErrorResumeNext {
                            when (it) {
                            //TODO this is OkHTTPClient timeout feature. Fix this in future
                                is InterruptedIOException -> Single.just(listOf())
                            //TODO this is RestAPI feature. API return 404 when group no found
                                is HttpException -> when (it.code()) {
                                    404 -> Single.just(listOf())
                                    else -> Single.error(it)
                                }
                                else -> Single.error(it)
                            }
                        }
            }
}