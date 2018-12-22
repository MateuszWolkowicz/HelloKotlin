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


interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since on out we need anything extends Any. String is Any (is subtype of)
    // ...
}

fun demo0(anys: Source<Any>) {
    val objects: Source<String> = anys // This is NOT OK, since on out we need anything extends String. Any is not a String (is NOT subtype of)
    // ...
}

fun demo1(ints: Source<Int>) {
    val objects2: Source<Any> = ints // This is OK, since on out we need anything extends Any. Int is Any (is subtype of)
    // ...
}

fun demo3(anys: Source<Any>) {
    val objects3: Source<Number> = anys // This is NOT OK, since on out we need anything extends Number. Any is not Number (is NOT subtype of)
    // ...
}

fun demo4(ints: Source<Int>) {
    val objects3: Source<Number> = ints // This is OK, since on out we need anything extends Number. Int is Number (is subtype of)
    // ...
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, we can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}

fun demo1(x: Comparable<Number>) {
    x.compareTo(1) // 1 has type Int, which is a subtype of Number
    // Thus, we can assign x to a variable of type Comparable<Int>
    val y: Comparable<Int> = x // OK!
}

fun demo2(x: Comparable<Double>) {
    x.compareTo(1) // 1 has type Int, which is a NOT subtype of Double
    // Thus, we can NOT assign x to a variable of type Comparable<Double>
    val y: Comparable<Int> = x // NOT OK!
}

fun demo3(x: Comparable<Any>) {
    x.compareTo(1) // 1 has type Int, which is a subtype of Any
    // Thus, we can assign x to a variable of type Comparable<Int>
    val y: Comparable<Int> = x // OK!
}


class Array<T>(val size: Int) {
    fun get(index: Int): T {}
    fun set(index: Int, value: T) {}
}

class Array2<in T>(val size: Int) {
    private fun get(index: Int): T {} // OK (private prevents from OUT because it won't be ever accessible)
    //    fun get(index: Int): T { } // NOT OK (only IN allowed and T is OUT)
    fun set(index: Int, value: T) {} // OK because T is IN
}

class Array3<out T>(val size: Int) {
    fun get(index: Int): T {} // OK beacuse T is OUT
    private fun set(index: Int, value: T) {} // OK (private prevents from IN because it won't be ever accessible)
//    fun set(index: Int, value: T) {} // NOT OK (only OUT allowed and T is IN)
}