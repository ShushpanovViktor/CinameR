package com.github.example.cinemaonline.feature.about_movie_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.example.cinemaonline.R
import com.github.example.cinemaonline.base.utils.genresToString
import com.github.example.cinemaonline.base.utils.loadImage
import com.github.example.cinemaonline.databinding.FragmentAboutMovieBinding
import com.github.example.cinemaonline.feature.movies_screen.domain.model.Movie

class AboutMovieFragment : Fragment(R.layout.fragment_about_movie) {
    companion object {
        private const val MOVIE_KEY = "movie"
        fun newInstance(movie: Movie) = AboutMovieFragment().apply {
            arguments = bundleOf(Pair(MOVIE_KEY, movie))
        }
    }

    private val binding: FragmentAboutMovieBinding by viewBinding(FragmentAboutMovieBinding::bind)
    private val movie: Movie by lazy {
        requireArguments().getParcelable(MOVIE_KEY)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cardPoster.loadImage(movie.posterPath)
            cardMovieGenres.text = genresToString(movie.genres)
            cardMovieOverview.text = movie.overview
        }
    }
}