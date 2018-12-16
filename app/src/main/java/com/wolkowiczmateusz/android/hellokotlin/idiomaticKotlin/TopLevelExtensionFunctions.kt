package com.wolkowiczmateusz.android.hellokotlin.idiomaticKotlin

/**
 * https://github.com/phauer/blog-related/blob/master/kotlin-idiomatic/src/main/kotlin/idiomaticKotlin
 */

// In Java, you often create static util methods in util classes.
object StringUtil {
    fun countAmountOfX(string: String): Int {
        return string.length - string.replace("x", "").length
    }
}
//StringUtil.countAmountOfX("xKotlinxFunx") //3

// In Kotlin, remove the unnecessary wrapping util class and use top-level functions instead
// Often, you can additionally use extension functions, which increases readability ("like a story").
fun String.countAmountOfX(): Int {
    return length - replace("x", "").length
}
//"xKotlinxFunx".countAmountOfX() //3