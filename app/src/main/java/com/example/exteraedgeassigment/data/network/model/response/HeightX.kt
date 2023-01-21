package com.example.exteraedgeassigment.data.network.model.response

import com.google.gson.annotations.SerializedName

data class HeightX(
    @SerializedName("feet")
    val feet: Double,
    @SerializedName("meters")
    val meters: Double
)