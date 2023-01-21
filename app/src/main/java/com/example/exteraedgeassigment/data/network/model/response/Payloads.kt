package com.example.exteraedgeassigment.data.network.model.response

import com.google.gson.annotations.SerializedName

data class Payloads(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairing,
    @SerializedName("option_1")
    val option1: String
)