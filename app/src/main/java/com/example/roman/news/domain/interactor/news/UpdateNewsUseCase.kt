package com.example.roman.news.domain.interactor.news

import com.example.roman.news.data.model.News
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

class UpdateNewsUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val repository: NewsRepository
) : SingleUseCase<List<News>, String>(io, ui) {

    override fun buildUseCase(param : String): Single<List<News>> = repository.updateNews(param)

}