package com.wolkowiczmateusz.android.hellokotlin

import java.util.*

class VarVal {

    var fish = 3
    var numberOfFish = 3
    var numberOfPlants = 10

    fun main() {
        println("Hello, world!!!")
        charVsString()
        varVal()
        nullability()
        ifElse()
        countFishes(fish)
        conversion(3, "4")
        listArray()
        loops()
    }

    private fun charVsString() {
        var charType = 's' // '' for char
        var stringType = "s" // "" for string
         // charType = stringType // error
    }

    fun varVal() {
        val aquarium = "my aquarium"
        // aquarium = "not allowed" //error it's immutable (final)
        var fish = 50
        fish = 24 //ok it's mutable
        var snails: Int = 12
    }

    fun nullability() {
        // var rocks: Int = null //Error
        var marbles: Int? = null
        var lotsOfFish: List<String?> =
                listOf(null, null)

    }

    fun ifElse() {

        if (numberOfFish > numberOfPlants) {
            println("Good ratio!")
        } else {
            println("unhealthy ratio")
        }
        var fish: Int = 50
        if (fish in 1..100) println(fish)
        var fish2: Int = 103
        if (fish2 in 1..100) println(fish2)
        var temperature: Int = 1
        val isHot =
                if (temperature > 90) true else false
        println(isHot)
    }

    fun countFishes(fish: Int) {
        var lotsOfFish: List<Int?> = listOf(
                fish.times(6),
                fish.div(10),
                fish.plus(3),
                fish.minus(3))
        println(lotsOfFish)
    }

    fun conversion(first: Int, second: String) {
        println("1".toInt())
        println(2.toString())
        println(first.toString())
        println(second.toInt())

    }

    fun listArray() {
        val swarm = swarmList()
        println(swarm)

        val bigSwarm = arrayOf(swarm,
                arrayOf("dolphin", "whale", "orka"))
        println(bigSwarm.toList())
        val array = Array(5) { it * 2 }
        println(array)
        val school =
                arrayOf("tuna", "salmon", "shark")
        val mix = arrayOf("fish", 2)
        println(Arrays.toString(intArrayOf(2, 1)))
    }

    private fun swarmList(): List<Any> {
        val myList =
                mutableListOf("tuna", "shark")
        myList.remove("shark") // OK!
        val swarm = listOf(3, myList)
        return swarm
    }

    fun loops() {
        val swarm = swarmList()
        for (element in swarm) {
            println(element.toString() + " element")
        }
        for ((index, element) in
        swarm.withIndex()) {
            println("Fish at $index is $element")
        }

        for (i in 'b'..'g') print(i)
        println("")
        for (i in 1..5) print(i)
        println("")
        for (i in 5 downTo 1) print(i)
        println("")
        for (i in 3..6 step 2) print(i)
    }


}