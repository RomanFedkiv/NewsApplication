package com.example.roman.news.domain.interactor.config

import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.completable.CompletableUseCase
import com.example.roman.news.domain.repository.NewsConfigRepository
import javax.inject.Inject

class CreateNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val configRepository: NewsConfigRepository
) : CompletableUseCase<ConfigNews>(io, ui) {

    override fun buildUseCase(param: ConfigNews) = configRepository
            .createConfig(param)
}