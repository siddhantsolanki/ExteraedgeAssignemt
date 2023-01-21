package com.example.exteraedgeassigment.data.local

import com.example.exteraedgeassigment.domain.local.repository.DbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DbRepositoryImpl @Inject constructor(private val db: RocketDatabase ) : DbRepository{
    override suspend fun insertRockets(rockets: List<RocketDatabaseData>) = db.rocketDao().insertRockets(rockets)

    override suspend fun deleteRockets() = db.rocketDao().deleteRockets()

    override fun getAllRockets(): Flow<List<RocketDatabaseData>> = db.rocketDao().getAllRockets()

    override fun getRocketDetails(id: String): Flow<RocketDatabaseData> = db.rocketDao().getRocketDetails(id)
}