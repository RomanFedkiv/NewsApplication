package com.example.roman.news.domain.interactor.search

import com.example.roman.news.data.model.ConfigNews
import com.example.roman.news.domain.IOThreadFactory
import com.example.roman.news.domain.UIThreadFactory
import com.example.roman.news.domain.interactor.utils.single.SingleUseCase
import com.example.roman.news.domain.repository.SearchNewsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetLatestQueryUseCase @Inject constructor(
        io: IOThreadFactory,
        ui: UIThreadFactory,
        private val repository: SearchNewsRepository
) : SingleUseCase<List<ConfigNews>, Unit>(io, ui) {

    override fun buildUseCase(param : Unit): Single<List<ConfigNews>> =
            repository.getLatestsQuery()

}