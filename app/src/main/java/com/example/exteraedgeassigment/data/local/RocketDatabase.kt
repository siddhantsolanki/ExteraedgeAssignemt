package com.example.exteraedgeassigment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.exteraedgeassigment.utilities.DataConverter

@Database(entities = [RocketDatabaseData::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class RocketDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketDatabaseDao

}