package com.example.exteraedgeassigment.utilities

import androidx.room.TypeConverter

class DataConverter {
    @TypeConverter
    fun convertListToString(data: List<String>): String{
        var result=""
        data.forEach {
            result+= "$it,"
        }
        return result
    }

    @TypeConverter
    fun convertStringToList(data: String): List<String>{
        var result = ArrayList<String>()
        var dataSplit = data.split(",")
        dataSplit.forEach {
            if(!it.isNullOrEmpty())
                result.add(it)
        }
        return result.toList()
    }

}