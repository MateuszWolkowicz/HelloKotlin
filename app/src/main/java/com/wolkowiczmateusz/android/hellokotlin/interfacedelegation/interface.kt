package com.wolkowiczmateusz.android.hellokotlin.interfacedelegation

import com.wolkowiczmateusz.android.hellokotlin.abstractclassandinterfaces.Plecostomus

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus1()
    println("Fish has color ${pleco.color}")
    pleco.eat()
    val plecoEmpty = PlecostomusEmptyBody()
    println("Fish has color ${plecoEmpty.color}")
    pleco.eat()
}

interface FishAction1 {
    fun eat()
}

interface FishColor {
    val color: String
}

// /class Plecostomus1 : FishAction, FishColor by GoldColor {
//    override fun eat() {
//        println("eat algea")
//    }
//}

class Plecostomus1(fishColor: FishColor = GoldColor) : FishAction1, FishColor by fishColor {
    override fun eat() {
        println("eat algea")
    }
}

//interface delegation
object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintFishAction(val food: String) : FishAction1 {
    override fun eat() {
        println(food)
    }

}

class PlecostomusEmptyBody(fishColor: FishColor = GoldColor) :
        FishAction1 by PrintFishAction("a lot of algea"),
        FishColor by fishColor
