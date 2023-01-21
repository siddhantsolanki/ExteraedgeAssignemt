package com.example.exteraedgeassigment.data.network.model.response

import com.google.gson.annotations.SerializedName

data class LandingLegs(
    @SerializedName("material")
    val material: Any,
    @SerializedName("number")
    val number: Int
)