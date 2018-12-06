package com.wolkowiczmateusz.android.hellokotlin.specialpurposeclasses

//singleton create with "object" keyword
object MobyDickWhale {
    val author = "Herman Melville"
    fun jump() {
        //
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

//subclasses only in the same file
sealed class Seal

class Sealion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is Sealion -> "sea lion"
    }
}