package com.example.exteraedgeassigment.domain.local.repository

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import kotlinx.coroutines.flow.Flow

interface DbRepository {
    suspend fun insertRockets(rockets: List<RocketDatabaseData>)
    suspend  fun deleteRockets()
    fun getAllRockets(): Flow<List<RocketDatabaseData>>
    fun getRocketDetails(id: String): Flow<RocketDatabaseData>
}