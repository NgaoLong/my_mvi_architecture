package com.run.my_mvi_architecture.di

import com.run.my_mvi_architecture.domain.repository.MovieRepository
import com.run.my_mvi_architecture.domain.usecase.GetMovieDetailUseCase
import com.run.my_mvi_architecture.domain.usecase.GetMoviesUseCase
import com.run.my_mvi_architecture.domain.usecase.MovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideMovieUseCases(repository: MovieRepository): MovieUseCases {
        return MovieUseCases(
            getMovies = GetMoviesUseCase(repository),
            getMovieDetail = GetMovieDetailUseCase(repository)
        )
    }
}
