package com.wolkowiczmateusz.android.hellokotlin.collections

fun main(args: Array<String>) {
    val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
//    println(reverseList(testList))
    println(testList.reversed()) // simpler than this above


    // mutable list
    val symptoms = mutableListOf("white spots", "red spots", "noteating", "bloated", "belly up")
    symptoms.add("white fungus")
    symptoms.remove("white fungus")
    symptoms.contains("red") // false
    symptoms.contains("red spots") //true

    println(symptoms.subList(4, symptoms.size)) //[belly up]
    listOf(1, 5, 3).sum() // 9
    listOf("a", "b", "cc").sumBy { it.length } // 4


    //maps
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    println(cures["white spots"])
    println(cures.getOrDefault("bloating", "sorry I don't know"))
    cures.getOrElse("bloating") { "No cure for this" }
    val intentory = mutableMapOf("fish net" to 1)
    intentory.put("tank scrubber", 3)
    intentory.remove("fish net")

}

//fun reverseList(list: List<Int>): List<Int> {
//    val result = mutableListOf<Int>()
//    for (i in 0..list.size - 1) {
//        result.add(list[list.size - i - 1])
//    }
//    return result
//}
//
//fun reverseListAgain(list: List<Int>): List<Int> {
//    val result = mutableListOf<Int>()
//    for (i in list.size - 1 downTo 0) {
//        result.add(list.get(i))
//    }
//    return result
//}
