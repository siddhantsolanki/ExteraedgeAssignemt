package com.example.exteraedgeassigment.utilities

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class DataConverterTest {

    @Test
    fun convertListToString() {
        var data = ArrayList<String>()
        data.add("this")
        data.add("is")
        data.add("test")
        data.add("data")
        var testString = "this,is,test,data,"
        assertEquals(testString, DataConverter().convertListToString(data))
    }

    @Test
    fun convertStringToList() {
        var data = ArrayList<String>()
        data.add("this")
        data.add("is")
        data.add("test")
        data.add("data")
        var testString = "this,is,test,data,"
        var result = DataConverter().convertStringToList(testString)
        for(i in 0 until result.size){
            assertEquals(data[i],result[i])
        }
    }

    @Test
    fun getInchesFromMetersTest(){
        var resultOne = "39.37"
        var resultTwo = "78.74"
        var resultThree = "98.42"
        Assert.assertEquals(resultOne, Utils.getInchesFromMeters(1.0))
        Assert.assertEquals(resultTwo, Utils.getInchesFromMeters(2.0))
        Assert.assertEquals(resultThree, Utils.getInchesFromMeters(2.5))
    }
}