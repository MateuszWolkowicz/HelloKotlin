package com.wolkowiczmateusz.android.hellokotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    one()
}

fun one() {
    println("Start")

// Start a coroutine
    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }

    Thread.sleep(2000) // wait for 2 seconds
    println("Stop")
}

fun other() {
    launch {
        delay(1000)
    }
}

private val scope = CoroutineScope(Dispatchers.Main)

fun delayIOScopeAndBackToMain() {

    scope.launch {
        withContext(IO) {
            println("Start and wait")
            delay(5000)
        }
        println("Delay finished")
    }
}