package com.example.exteraedgeassigment.utilities

import java.math.RoundingMode
import java.text.DecimalFormat

class Utils {
companion object {
    fun getInchesFromMeters(data: Double): String {
        val inches = data * 39.3701
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundOff = df.format(inches)
        return roundOff.toString()
    }
}
}