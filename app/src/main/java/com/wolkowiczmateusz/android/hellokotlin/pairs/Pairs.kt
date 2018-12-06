package com.wolkowiczmateusz.android.hellokotlin.pairs

val equipment = "fishnet" to "catching fish" to "of big size" to "and strong"
val equip = ("fishnet" to "catching fish") to ("of big size" to "and strong")
val fishnet = "fishnet" to "catching fish"
fun main(args: Array<String>) {
    val (tool, use) = fishnet
    println("The $tool is a tool for $use.")
    // The fishnet is a tool for a catching fish
    val fishnetString = fishnet.toString()
    println(fishnetString)
    // (fishnet,carching fish)
    println(fishnet.toList())
    //[fishnet, catching fish]
    fun giveMeATool(): Pair<String, String> {
        return "fishnet" to "catching"
    }

    val (tool1, use1) = giveMeATool()
    println(tool1)
    //fishnet
    println(use1)
    //catching
}
