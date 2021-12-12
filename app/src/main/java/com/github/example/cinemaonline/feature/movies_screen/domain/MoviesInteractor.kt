package com.github.example.cinemaonline.feature.movies_screen.domain

import com.github.example.cinemaonline.base.funcs.attempt
import com.github.example.cinemaonline.feature.movies_screen.data.api.MoviesRepository

class MoviesInteractor(private val moviesRepository: MoviesRepository) {
    suspend fun fetchMovies() = attempt {
        moviesRepository.fetchMovies()
    }
}