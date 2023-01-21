package com.example.exteraedgeassigment.domain.network.repository

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import kotlinx.coroutines.flow.Flow

interface RocketRepository {
    fun getRocketsList(): Flow<List<RocketDatabaseData>>

    fun getRocketDetails(id: String): Flow<RocketDatabaseData>
}