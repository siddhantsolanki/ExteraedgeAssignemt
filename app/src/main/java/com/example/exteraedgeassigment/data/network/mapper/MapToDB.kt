package com.example.exteraedgeassigment.data.network.mapper

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.data.network.model.response.RocketListResponse

fun RocketListResponse.mapToDbData() : RocketDatabaseData{
    val result = RocketDatabaseData()
    return result.let {
        it.country = this.country
        it.id = this.id
        it.name = this.name
        it.image = this.flickrImages.map { it }
        it.enginesCount = this.engines.number
        it.activeStatus = this.active
        it.costPerLaunch = this.costPerLaunch.toString()
        it.description = this.description
        it.wikipediaLink = this.wikipedia
        it.diameterFeet = this.diameter.feet.toString()
        it.diameterInch = this.diameter.meters.toString()
        it.heightInch = this.height.meters.toString()
        it.heightFeet = this.height.feet.toString()
        it.successRate = this.successRatePct.toString()
        it
    }
}