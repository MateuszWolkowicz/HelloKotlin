package com.wolkowiczmateusz.android.hellokotlin.coroutines

val sequence = sequence {
    println("one")
    yield(1)

    println("two")
    yield(2)

    println("three")
    yield(3)

    println("done")
}

fun run() {
    for (value in sequence) {
        println("The value is $value")
    }

}


