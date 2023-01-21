package com.example.exteraedgeassigment.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocketDatabase")
data class RocketDatabaseData(
    var name: String = "",
    var country: String = "",
    var enginesCount: Int = 0,
    var image: List<String> = emptyList(),
    @PrimaryKey var id: String = "",
    var activeStatus: Boolean = false,
    var costPerLaunch: String = "",
    var successRate: String = "",
    var description: String = "",
    var wikipediaLink: String = "",
    var heightFeet: String = "",
    var heightInch: String = "",
    var diameterFeet: String = "",
    var diameterInch: String = ""
)