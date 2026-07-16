package com.run.my_mvi_architecture.data.model.movie

import com.google.gson.annotations.SerializedName

data class MovieSearchResponse(
    @SerializedName("Search") val search: List<MovieDto>?,
)
