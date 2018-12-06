package com.wolkowiczmateusz.android.hellokotlin


class AquariumMutable(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
//class AquariumMutable(length: Int, width: Int, height: Int) {
//    var width: Int = 20
//    var height: Int = 40
//    var length: Int = 100

//    val volume : Int
//        get() {
//        return width * height * length / 1000
//        }

    fun volume0(): Int {
        return width * height * length / 1000
    }

    fun volume0Simpler(): Int = width * height * length / 1000

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000 // cm3
        val tank = water + water *0.1
        length = 10
        height = (tank / (length * width)).toInt()
    }

}
