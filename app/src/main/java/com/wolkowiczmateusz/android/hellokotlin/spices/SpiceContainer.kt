package com.wolkowiczmateusz.android.hellokotlin.spices

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}

fun main(args: Array<String>) {
    for (element in spiceCabinet) println(element.label)
}

val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy")))

