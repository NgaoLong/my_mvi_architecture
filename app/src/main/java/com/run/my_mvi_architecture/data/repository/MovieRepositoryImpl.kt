package com.run.my_mvi_architecture.data.repository

import com.run.my_mvi_architecture.data.model.movie.toDomain
import com.run.my_mvi_architecture.data.model.movie_details.toDomain
import com.run.my_mvi_architecture.data.remote.MovieApi
import com.run.my_mvi_architecture.domain.model.Movie
import com.run.my_mvi_architecture.domain.model.MovieDetail
import com.run.my_mvi_architecture.domain.repository.MovieRepository
import javax.inject.Inject
import com.run.my_mvi_architecture.BuildConfig

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {

    private val apiKey = BuildConfig.OMDB_API_KEY // Replace with OMDb key

    override suspend fun getMovies(query: String): List<Movie> {
        val response = api.searchMovies(apiKey, query)
        return response.search?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getMovieDetail(id: String): MovieDetail {
        val response = api.getMovieDetail(id, apiKey)
        return response.toDomain()
    }
}
