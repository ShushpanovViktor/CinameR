package com.github.example.cinemaonline.feature.movies_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ResultsRemoteModel(
    @SerializedName("results") val results: List<ResultRemoteModel>
)
