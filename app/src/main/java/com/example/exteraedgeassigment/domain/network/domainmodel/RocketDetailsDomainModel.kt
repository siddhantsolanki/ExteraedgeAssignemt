package com.example.exteraedgeassigment.domain.network.domainmodel

data class RocketDetailsDomainModel(
    var name: String = "",
    var country: String = "",
    var enginesCount: Int = 0,
    var image: List<String> = emptyList(),
    var id: String = "",
    var activeStatus: Boolean = false,
    var costPerLaunch: String = "",
    var successRate: String = "",
    var description: String = "",
    var wikipediaLink: String = "",
    var heightFeet: String = "",
    var heightInch: String = "",
    var diameterFeet: String = "",
    var diameterInch: String = ""
) : java.io.Serializable