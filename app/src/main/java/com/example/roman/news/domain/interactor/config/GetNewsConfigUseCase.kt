package com.example.roman.news.domain.interactor.config

import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.data.model.News
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.NewsConfigRepository
import com.example.roman.news.domain.repository.TopHeadlinesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val repository: NewsConfigRepository
) : SingleUseCase<List<ConfigNews>, Unit>(io, ui) {

    override fun buildUseCase(param : Unit) = repository.getConfig()

}