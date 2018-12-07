package com.wolkowiczmateusz.android.hellokotlin.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<T : WaterSupply>(val waterSupply: T)

fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
//    val aquarium = Aquarium(TapWater()) //the same
    aquarium.waterSupply.addChemicalCleaners()
//    val aquarium2 = Aquarium<TapWater>("string") //not possible if T: WaterSupply

}
