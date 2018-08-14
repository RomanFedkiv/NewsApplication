package com.example.roman.news.domain.interactor.configSearch

import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.SearchNewsConfigRepository
import javax.inject.Inject

class GetSearchNewsConfigUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val repositorySearch: SearchNewsConfigRepository
) : SingleUseCase<List<ConfigSearchNews>, Unit>(io, ui) {

    override fun buildUseCase(param : Unit) = repositorySearch.getConfig()

}