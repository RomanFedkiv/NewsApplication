package com.example.roman.news.domain.interactor.topHeadlines

import android.util.Log
import com.example.roman.news.data.model.News
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val repository: TopHeadlinesRepository
) : SingleUseCase<List<News>, Unit>(io, ui) {

    override fun buildUseCase(param : Unit): Single<List<News>> = repository.getTopHeadlinesNews()

}