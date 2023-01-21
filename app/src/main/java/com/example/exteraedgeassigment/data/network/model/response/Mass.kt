package com.example.exteraedgeassigment.data.network.model.response

import com.google.gson.annotations.SerializedName

data class Mass(
    @SerializedName("kg")
    val kg: Int,
    @SerializedName("lb")
    val lb: Int
)