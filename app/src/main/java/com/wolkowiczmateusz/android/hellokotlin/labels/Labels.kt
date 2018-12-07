package com.wolkowiczmateusz.android.hellokotlin.labels

fun labels() {

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i > 10) break@loop
        }
    }
}

fun foo() { //12
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        print(it)
    }
    println("this point is unreachable")
}

fun foo2() { //1245 done with explicit label
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

fun foo3() { // the same as foo2
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with implicit label")
}