package com.example.exteraedgeassigment.domain

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.utilities.DomainResult
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getRockets(): Flow<DomainResult<List<RocketDatabaseData>>>
    fun getRocketDetails(id: String): Flow<DomainResult<RocketDatabaseData>>
}