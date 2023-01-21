package com.example.exteraedgeassigment.data.network.repository

import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.data.network.ApiService
import com.example.exteraedgeassigment.data.network.mapper.mapToDbData
import com.example.exteraedgeassigment.domain.network.repository.RocketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RocketRepositoryImpl @Inject constructor( private val apiService: ApiService) : RocketRepository {
    override fun getRocketsList(): Flow<List<RocketDatabaseData>> = flow {
        val result = apiService.getRocketsList()
        if(result.isSuccessful){
            val response = result.body()?.map { it.mapToDbData() }
            emit(response!!)
            if(response.isNullOrEmpty()){
                Unit
            }else{
                Unit
            }
        }
        else{
            Unit
        }
    }

    override fun getRocketDetails(id: String): Flow<RocketDatabaseData> = flow {
        val result = apiService.getRocketDetails(id)
        if(result.isSuccessful){
            if(result.body() == null){
                Unit
            }else{
                emit(result.body()!!.mapToDbData())
            }
        }
        else{
            Unit
        }
    }
}