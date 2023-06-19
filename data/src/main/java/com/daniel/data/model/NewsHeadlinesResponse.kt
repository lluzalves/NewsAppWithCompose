package com.daniel.data.model

import com.google.gson.annotations.SerializedName


data class NewsHeadlinesResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("totalResults")
    var totalResults: Int,

    @SerializedName("articles")
    var headlines: List<Headline>
)