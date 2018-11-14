package com.wolkowiczmateusz.android.hellokotlin

import java.util.*

class Functions {
    fun main(args: Array<String>) {
        println("Hello ${args[0]} ")
        dayOfWeek()
        feedTheFish()
        swim()
        swim("slow")
        swim(speed = "very slow")

        swim()
        swim(50, "slow")
        swim(speed = "very slow", time = 30)
        filterTest()
    }

    private fun filterTest() {
        var decorations = listOf("rock", "pop", "metal", "popi")
        println(decorations.filter { it[0] == 'm' })
        println(decorations.filter { it.contains("po") }.sortedBy { it.length })
    }

    private fun swim(speed: String = "fast") {
        //repeate
        repeat(2) {
            println("swimming $speed")
        }

    }

    private fun swim(time: Int, speed: String = "fast") {
        println("swimming $speed , speed equals = $time")
    }

    // compact function
    private fun swim(time: Int, speed: String = "fast", style: String = getStyle()) {
        println("swimming $speed , speed equals = $time")
    }

    fun getStyle() = "smooth"

    private fun feedTheFish() {
        val day = randomDay()
        val food = "pellets"
        println("Today is $day and the fish eat $food")
    }

    fun randomDay(): String {
        val week = listOf("Monday", "Sunday")
        return week[Random().nextInt(2)];
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