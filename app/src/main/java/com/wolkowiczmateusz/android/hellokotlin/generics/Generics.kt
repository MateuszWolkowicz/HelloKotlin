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

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water frim $waterSupply")
    }

  inline  fun <reified R: WaterSupply> hasWaterSupplyOfType() =  waterSupply is R

}


interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified  T: WaterSupply> WaterSupply.isOfType() = this is T

fun genericsExample() {
    val cleaner = TapWaterCleaner()
//    val aquarium = Aquarium<TapWater>(TapWater())
    val aquarium = Aquarium(TapWater()) //the same
    aquarium.addWater(cleaner) // need in
    addItemTo(aquarium) // need out
    aquarium.waterSupply.addChemicalCleaners()
//    val aquarium2 = Aquarium<TapWater>("string") //not possible if T: WaterSupply
    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>() // true
    aquarium.waterSupply.isOfType<LakeWater>() // false
}


