package com.github.example.cinemaonline.base.nav

import com.github.example.cinemaonline.feature.about_movie_screen.ui.AboutMovieFragment
import com.github.example.cinemaonline.feature.errors_screen.ui.ErrorsScreenFragment
import com.github.example.cinemaonline.feature.movie_player_screen.ui.MoviePlayerFragment
import com.github.example.cinemaonline.feature.movies_screen.domain.model.Movie
import com.github.example.cinemaonline.feature.movies_screen.ui.MoviesListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun movieListScreen() = FragmentScreen {
        MoviesListFragment.newInstance()
    }

    fun aboutMovie(movie: Movie) = FragmentScreen {
        AboutMovieFragment.newInstance(movie)
    }

    fun moviePlayer(movie: Movie) = FragmentScreen {
        MoviePlayerFragment.newInstance(movie)
    }

    fun errorsScreen() = FragmentScreen {
        ErrorsScreenFragment.newInstance()
    }
}