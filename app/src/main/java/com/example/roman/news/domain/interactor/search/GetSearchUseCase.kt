package com.example.roman.news.domain.interactor.search

import com.example.roman.news.data.model.News

import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.SearchNewsRepository
import javax.inject.Inject

class GetSearchUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val searchRepository: SearchNewsRepository
) : SingleUseCase<List<News>, String>(io, ui) {

    override fun buildUseCase(param: String) =
            searchRepository.searchNews(param)
}