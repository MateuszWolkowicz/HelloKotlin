package com.wolkowiczmateusz.android.hellokotlin.higherorderfunctions

// scoping functions
fun test() {
    var mood = "I am sad"

    run {
        val mood = "I am happy"
        println(mood) // I am happy
    }
    println(mood)  // I am sad
}

fun withVsRun() {
    // simpler better looking nullcheck with ?

// Yack!
    with(webview.settings) {
        this.javaScriptEnabled = true
        this.databaseEnabled = true
    }
// Nice.
    webview.settings.run {
        javaScriptEnabled = true
        databaseEnabled = true
    }
}

fun runVsLet() {
    stringVariable.run {
        println("The length of this String is $length") // could be used also as ${this.length} this is omitted
    }

// Similarly.
    stringVariable.let {
        println("The length of this String is ${it.length}")
    }

    /**
     * .let is more readable and clearer and we are able to change "it" to other name as for example ...
     */
    stringVariable.let { nonNullString ->
        println("The non null string is $nonNullString")
    }
}

/**
 * .let we can chain and pass value from one scope to another and it remember changes through the chain
 */
fun letVsAlso() {
    val original = "abc"
// Evolve the value and send to the next chain
    original.let {
        println("The original String is $it") // "abc"
        it.reversed() // evolve it as parameter to send to next let
    }.let {
        println("The reverse String is $it") // "cba"
        it.length  // can be evolve to other type
    }.let {
        println("The length of the String is $it") // 3
    }
// Wrong
// Same value is sent in the chain (printed answer is wrong)
    original.also {
        println("The original String is $it") // "abc"
        it.reversed() // even if we evolve it, it is useless
    }.also {
        println("The reverse String is ${it}") // "abc"
        it.length  // even if we evolve it, it is useless
    }.also {
        println("The length of the String is ${it}") // "abc"
    }
// Corrected for also (i.e. manipulate as original string
// Same value is sent in the chain
    original.also {
        println("The original String is $it") // "abc"
    }.also {
        println("The reverse String is ${it.reversed()}") // "cba"
    }.also {
        println("The length of the String is ${it.length}") // 3
    }
}

fun letAndAlsoCombining() {
    // Normal approach
    fun makeDir(path: String): File {
        val result = File(path)
        result.mkdirs()
        return result
    }

    // Improved approach
    fun makeDir(path: String) = path.let { File(it) }.also { it.mkdirs() }
}