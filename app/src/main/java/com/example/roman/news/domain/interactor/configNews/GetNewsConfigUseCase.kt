package com.example.roman.news.domain.interactor.configNews

import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.NewsConfigRepository
import com.example.roman.news.domain.repository.SearchNewsConfigRepository
import javax.inject.Inject

class GetNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val configRepository: NewsConfigRepository
) : SingleUseCase<NewsConfig, Unit>(io, ui) {

    override fun buildUseCase(param : Unit) = configRepository.getConfig()

}