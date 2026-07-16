package com.run.my_mvi_architecture.domain.usecase

import com.run.my_mvi_architecture.domain.model.MovieDetail
import com.run.my_mvi_architecture.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(id: String): MovieDetail {
        return repository.getMovieDetail(id)
    }
}
