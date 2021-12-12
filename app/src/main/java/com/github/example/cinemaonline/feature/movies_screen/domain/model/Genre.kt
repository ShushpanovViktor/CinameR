package com.github.example.cinemaonline.feature.movies_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(val name: String) : Parcelable
