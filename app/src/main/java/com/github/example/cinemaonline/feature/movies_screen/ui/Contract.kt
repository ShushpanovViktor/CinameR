package com.github.example.cinemaonline.feature.movies_screen.ui

import com.github.example.cinemaonline.base.view_model.Event
import com.github.example.cinemaonline.feature.movies_screen.domain.model.Movie

data class ViewState(
    val movies: List<Movie>,
    val errorMessage: String?
) {
    val isInErrorState: Boolean = errorMessage != null
    val isLoading: Boolean = isInErrorState || movies.isEmpty()
}

sealed class UiEvent : Event {
    object FetchMovies : UiEvent()
    data class OnInfoButtonClicked(val movie: Movie) : UiEvent()
    data class OnPlayButtonClicked(val movie: Movie) : UiEvent()
    object OnRetryClicked : UiEvent()
}

sealed class DataEvent : Event {
    data class SuccessMoviesRequest(val movies: List<Movie>) : DataEvent()
    data class ErrorMoviesRequest(val errorMessage: String) : DataEvent()
}