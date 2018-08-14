package com.example.roman.news.domain.interactor.configNews

import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.completable.CompletableUseCase
import com.example.roman.news.domain.repository.NewsConfigRepository
import javax.inject.Inject

class CreateNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val configRepository: NewsConfigRepository
) : CompletableUseCase<NewsConfig>(io, ui) {

    override fun buildUseCase(param: NewsConfig) = configRepository
            .createConfig(param)
}