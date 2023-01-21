package com.example.exteraedgeassigment.data.network.mapper

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.domain.network.domainmodel.RocketDetailsDomainModel

fun RocketDatabaseData.mapToUi(): RocketDetailsDomainModel{
    var result = RocketDetailsDomainModel()
    return result.let {
        it.country = this.country
        it.id = this.id
        it.name = this.name
        it.image = this.image.map { it }
        it.enginesCount = this.enginesCount
        it.activeStatus = this.activeStatus
        it.costPerLaunch = this.costPerLaunch.toString()
        it.description = this.description
        it.wikipediaLink = this.wikipediaLink
        it.diameterFeet = this.diameterFeet
        it.diameterInch = this.diameterInch
        it.heightInch = this.heightInch
        it.heightFeet = this.heightFeet
        it.successRate = this.successRate
        it
    }
}