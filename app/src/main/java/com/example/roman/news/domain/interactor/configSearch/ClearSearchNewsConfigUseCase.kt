package com.example.roman.news.domain.interactor.configSearch

import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.completable.CompletableUseCase
import com.example.roman.news.domain.repository.SearchNewsConfigRepository
import javax.inject.Inject

class ClearSearchNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val configRepositorySearch: SearchNewsConfigRepository
) : CompletableUseCase<Unit>(io, ui) {

    override fun buildUseCase(param: Unit) = configRepositorySearch.deleteConfig()

}