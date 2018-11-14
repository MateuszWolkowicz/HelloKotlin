package com.wolkowiczmateusz.android.hellokotlin

import java.util.*

class Functions {
    fun main(args: Array<String>) {
        println("Hello ${args[0]} ")
        dayOfWeek()
    }

    fun dayOfWeek() {
        println("What day is it today ?")
        var day: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

        println(when (day) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Time has stopped"
        })

        when (day) {
            1 -> show("Monday")
            else -> show("other ")
        }
    }

    private fun show(s: String) {
        println(s + "day of the week")
    }
}