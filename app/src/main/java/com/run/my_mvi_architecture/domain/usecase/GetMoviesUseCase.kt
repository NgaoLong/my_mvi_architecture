package com.run.my_mvi_architecture.domain.usecase

import com.run.my_mvi_architecture.domain.model.Movie
import com.run.my_mvi_architecture.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String): List<Movie> =
        repository.getMovies(query)
}

