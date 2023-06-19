package com.daniel.data.model

import com.google.gson.annotations.SerializedName


data class HeadlineSource(
    @SerializedName("id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null
)