package com.wolkowiczmateusz.android.hellokotlin.extensionsfunctions

fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

fun extensionsExample() {
    "Does it have spces?".hasSpaces() // true
}