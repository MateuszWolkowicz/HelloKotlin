package com.wolkowiczmateusz.android.hellokotlin

import java.lang.Math.random
import java.util.*

class Lambdas {
    fun main() {
        swim()
        lambda1()
    }

    val swim = { println("swim \n") }
    var dirty = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 } // the same as waterFilter

    fun feedFish(dirty: Int) = dirty + 10

    private fun lambda1() {
        waterFilter(dirty)
        waterFilter2(dirty) // the same as waterFilter
        dirtyProcessor()
    }

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int { // function have to be a last parameter
        return operation(dirty)
    }

    fun dirtyProcessor() {
        dirty = updateDirty(dirty, waterFilter)
        dirty = updateDirty(dirty, ::feedFish)
        dirty = updateDirty(dirty) { dirty ->
            dirty + 50
        }
        dirty = updateDirty(dirty, { dirty ->
            dirty + 50
        })
    }

    val random1 = random() // it will give every time the same value which was produced once at compile time
    val random2 = { random() } // it will produce random number every time it is accessed

    val rollDice = { Random().nextInt(12) + 1 }

    val rollDice0 = { sides: Int ->
        Random().nextInt(sides) + 1
    }

    val rollDice1 = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    val rollDice2: (Int) -> Int = { sides ->
        //the same as rollDice1 but created with function type notation
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    fun test() {
        rollDice()
        rollDice0(10)
        rollDice1(10)
        rollDice2(10)
        gamePlay(rollDice2(4))
    }

    fun gamePlay(diceRoll: Int) {
        // do something with the dice roll
        println(diceRoll)
    }


}