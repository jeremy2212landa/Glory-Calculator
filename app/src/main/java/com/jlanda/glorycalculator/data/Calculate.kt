package com.jlanda.glorycalculator.data

import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.log10


class calculate () {
    var wins = 0
    var elo = 0


     fun calculateMaxWin(wins:Int): Int {
         var result:Int = 0
         var number:Int = 0

         if (wins <= 150){
             result = wins * 20
         }else {
             number = wins * 2
             result = ((10 * (45 * (log10( number.toDouble() )* log10( number.toDouble() )) )) + 245).toInt()
         }
         return result
    }

    fun calculateBestRating(bestrating:Int): Int {
        var result:Int = 0

        var bestrating = bestrating
        if (bestrating < 1200){
            result = 250
        } else if (bestrating in 1200..1285){
            result = (10 * (25 + 0.872093023 * (86 - (1286 - bestrating)))).toInt()
        } else if (bestrating in 1286..1389){
            result = (10 * (100 + 0.721153846 * (104 - (1390 - bestrating)))).toInt()
        } else if (bestrating in 1390..1679){
            result = (10 * (187 + 0.389655172 * (290 - (1680 - bestrating)))).toInt()
        } else if (bestrating in 1680..1999){
            result = (10 * (300 + 0.428125 * (320 - (2000 - bestrating)))).toInt();
        } else if (bestrating in 2000..2299){
            result = (10 * (437 + 0.143333333 * (300 - (2300 - bestrating)))).toInt()
        } else if (bestrating >= 2300){
            result = (10 * (480 + 0.05 * (400 - (2700 - bestrating)))).toInt()
        }
        return result
    }

}