package com.example.exteraedgeassigment.data

import androidx.room.withTransaction
import com.example.exteraedgeassigment.data.local.RocketDatabase
import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.data.network.ApiService
import com.example.exteraedgeassigment.data.network.mapper.mapToDbData
import com.example.exteraedgeassigment.domain.MainRepository
import com.example.exteraedgeassigment.domain.local.repository.DbRepository
import com.example.exteraedgeassigment.domain.network.repository.RocketRepository
import com.example.exteraedgeassigment.utilities.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val rocketRepository: RocketRepository,
    private val dbRepository: DbRepository,
    private val db: RocketDatabase
): MainRepository {

   override fun getRockets() = networkBoundResource(
        query = {
//            rocketDao.getAllRockets()
                dbRepository.getAllRockets()
        },
        fetch = {
            delay(2000)
            rocketRepository.getRocketsList()
        },
        saveFetchResult = { rockets ->
            db.withTransaction {
                dbRepository.deleteRockets()
                dbRepository.insertRockets(rockets.first())
            }

        }
    )

   override fun getRocketDetails(id: String) = networkBoundResource(
        query = {
            dbRepository.getRocketDetails(id)
        },
        fetch = {
            delay(2000)
            dbRepository.getRocketDetails(id)
        },
        saveFetchResult = {
            Unit
        }
    )

}