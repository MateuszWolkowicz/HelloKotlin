package com.wolkowiczmateusz.android.hellokotlin

import com.wolkowiczmateusz.android.hellokotlin.abstractclassandinterfaces.FishAction
import com.wolkowiczmateusz.android.hellokotlin.abstractclassandinterfaces.Plecostomus
import com.wolkowiczmateusz.android.hellokotlin.abstractclassandinterfaces.Shark

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}
fun buildAquarium() {
    val myAquariumImmutable = AquariumImmutable()
    println("Length: ${myAquariumImmutable.length}" +
            "Width: ${myAquariumImmutable.width}" +
            "Height: ${myAquariumImmutable.height}"
    )

    val myAquariumMutable = AquariumMutable()
    println("Length: ${myAquariumMutable.length}" +
            "Width: ${myAquariumMutable.width}" +
            "Height: ${myAquariumMutable.height}"
    )
    myAquariumMutable.height = 80
    println("Height: ${myAquariumMutable.height} cm")
    println("Volume: ${myAquariumMutable.volume} liters")

    val smallAquarium = AquariumMutable(length = 20, width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    // second constructor with only numberOfFish and without body will get other parameters as standard ones
    val myAquarium2 = AquariumMutable(numberOfFish = 9)
    println("Small Aquarium: ${myAquarium2.volume} liters with" +
            "Length: ${myAquarium2.length}" +
            "Width: ${myAquarium2.width}" +
            "Height: ${myAquarium2.height}"
    )
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark : ${shark.color} \n Plecostomus: ${pleco.color} ")
    shark.eat()
    pleco.eat()

    feedFish(shark)
    feedFish(pleco)
}

fun feedFish(fish: FishAction) {
    fish.eat()
}


