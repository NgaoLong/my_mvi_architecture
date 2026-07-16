package com.run.my_mvi_architecture.domain.repository

import com.run.my_mvi_architecture.domain.model.Movie
import com.run.my_mvi_architecture.domain.model.MovieDetail


interface MovieRepository {
    suspend fun getMovies(query: String = "batman"): List<Movie>

    suspend fun getMovieDetail(id: String): MovieDetail
}
