package com.example.exteraedgeassigment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRockets(rockets: List<RocketDatabaseData>)

    @Query("DELETE FROM rocketDatabase")
    suspend fun deleteRockets()

    @Query("SELECT * FROM rocketDatabase")
    fun getAllRockets(): Flow<List<RocketDatabaseData>>

    @Query("SELECT * FROM rocketDatabase WHERE id LIKE :id")
    fun getRocketDetails(id: String) : Flow<RocketDatabaseData>
}