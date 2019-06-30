package com.wolkowiczmateusz.android.hellokotlin

import java.lang.Math.random
import java.util.*

class Lambdas {
    fun main() {
        swim()
        lambda1()
        goInvoke.invoke(1) //equivalent
        goInvoke(1) //equivalent with .invoke(1)

        //the same
        println( 4.predicate() )
        println( 3.predicate() )
        println( predicate(4) )
        println( predicate(3) )

        //the same
        println( otherPredicate.invoke(4) )
        println( otherPredicate.invoke(3) )
        println( otherPredicate(4) )
        println( otherPredicate(3) )
//        println( 3.otherPredicate() )  // not the same, not possible

        //the same
        println( 3.test("2") )
        println( test(3,"2") )

        //the same
        println( 3.test("ok") )
        println( test(3,"ok") )

        //the same
        println( 3.test2("ok",1) )
        println( test2(3,"ok",1) )
//        println( test2("ok",3,1) )  // not the same, not possible

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


    var goInvoke: (number: Int) -> Unit = {
        println("here $it")
    }


    val predicate : Int.() -> Boolean = {
        this % 2 != 0
    }

    val test: Int.(String) -> Boolean = {
        this % 2 != 0 && "ok" == it
    }

    val test2: Int.(String,Int) -> Boolean = {
        str,intt ->
        this % 2 != 0 && "ok" == str && intt == 0
    }

    val otherPredicate : (Int) -> Boolean = {
        it % 2 != 0
    }

}