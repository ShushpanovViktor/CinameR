package com.github.example.cinemaonline.feature.movies_screen.data.api

import com.github.example.cinemaonline.feature.movies_screen.domain.model.Movie

interface MoviesRepository {
    suspend fun fetchMovies(): List<Movie>
}