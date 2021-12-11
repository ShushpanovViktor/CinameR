package com.github.example.cion.feature.movies_screen.data

import com.github.example.cion.feature.movies_screen.data.api.model.GenreRemoteModel
import com.github.example.cion.feature.movies_screen.data.api.model.ResultRemoteModel
import com.github.example.cion.feature.movies_screen.domain.model.Genre
import com.github.example.cion.feature.movies_screen.domain.model.Movie

fun GenreRemoteModel.toDomain(): Genre = Genre(name = name)

fun ResultRemoteModel.toDomain(): Movie {
    val genres: List<Genre> = genres.map { genre -> genre.toDomain() }

    return Movie(
        id = id,
        posterPath = posterPath,
        title = title,
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        genres = genres,
        overview = overview,
        video = video
    )
}