package com.wolkowiczmateusz.android.hellokotlin.constvsval


/*
By default val properties are set at runtime. Adding a const modifier on a val would make a compile-time constant.
A const cannot be used with a var or on its own.
A const is not applicable on a local variable.
*/

const val rocks = 3
val number = 5
const val num = 5

fun complexFunctionCall() {}

val result = complexFunctionCall()
//const val result2 = complexFunctionCall() // can't do that  its set on compile time and we can't change it

const val CONSTANT = "top=level constant"

//singletone
object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

// no constant inside a class. We need to use wrapper companion objecy

class MyClass {
    companion object {
        const val CONSTAT3 = "constant inside companion"
    }
}
