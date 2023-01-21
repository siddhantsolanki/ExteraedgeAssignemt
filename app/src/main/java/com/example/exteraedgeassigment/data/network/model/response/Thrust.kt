package com.example.exteraedgeassigment.data.network.model.response

import com.google.gson.annotations.SerializedName

data class Thrust(
    @SerializedName("kN")
    val kN: Int,
    @SerializedName("lbf")
    val lbf: Int
)