package com.wolkowiczmateusz.android.hellokotlin.spices

import com.wolkowiczmateusz.android.hellokotlin.specialpurposeclasses.Color


fun main(args: Array<String>) {
    var curry = Curry(name = "Curry", spiciness = "lite")

}

abstract sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String,
            color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {
    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}