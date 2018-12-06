package com.wolkowiczmateusz.android.hellokotlin.abstractclassandinterfaces

abstract class AquariumFish {
    abstract val color: String
}

class Shark : AquariumFish(), FishAction {
    override fun eat() {
        println("hunt and eat fish")

    }

    override val color = "grey"
}


class Plecostomus : AquariumFish(), FishAction {
    override fun eat() {
        println("munch on algae")

    }

    override val color = "gold"
}

interface FishAction {
    fun eat()
}

