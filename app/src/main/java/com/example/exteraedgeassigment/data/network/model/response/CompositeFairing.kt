package com.example.exteraedgeassigment.data.network.model.response


import com.google.gson.annotations.SerializedName

data class CompositeFairing(
    @SerializedName("diameter")
    val diameter: Diameter,
    @SerializedName("height")
    val height: HeightX
)