package com.wolkowiczmateusz.android.hellokotlin

class Lambdas {
    fun main() {
        lambda1()
    }

    private fun lambda1() {
        var dirty = 20
        val waterFilter = {dirty: Int -> dirty /2}
        val waterFilter2: (Int) -> Int = {dirty -> dirty /2}
        waterFilter(dirty)

    }


}