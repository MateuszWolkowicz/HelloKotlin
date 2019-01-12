package com.wolkowiczmateusz.android.hellokotlin.higherorderfunctions

import android.os.Bundle

fun blub() {
    // Don't
    val dataSource = BasicDataSource()
    dataSource.driverClassName = "com.mysql.jdbc.Driver"
    dataSource.url = "jdbc:mysql://domain:3309/db"
    dataSource.username = "username"
    dataSource.password = "password"
    dataSource.maxTotal = 40
    dataSource.maxIdle = 40
    dataSource.minIdle = 4
}

// Do
val dataSource = BasicDataSource().apply {
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://domain:3309/db"
    username = "username"
    password = "password"
    maxTotal = 40
    maxIdle = 40
    minIdle = 4
}

fun applyUseCase1() {
    // Normal approach
    fun createInstance(args: Bundle): MyFragment {
        val fragment = MyFragment()
        fragment.arguments = args
        return fragment
    }

    // Improved approach
    fun createInstance(args: Bundle) = MyFragment().apply { arguments = args }
}

fun applyUseCase2() {
    // Normal approach
    fun createIntent(intentData: String, intentAction: String): Intent {
        val intent = Intent()
        intent.action = intentAction
        intent.data = Uri.parse(intentData)
        return intent
    }

    // Improved approach, chaining
    fun createIntent(intentData: String, intentAction: String) =
            Intent().apply { action = intentAction }
                    .apply { data = Uri.parse(intentData) }
}

fun applyVsWith() {
    // apply transform adn return the same object
    getDeveloper()
    //vs
    // with create new object transform and return this new one
    getPersonFromDeveloper(Developer())
}

fun getDeveloper(): Developer {
    return Developer().apply {
        developerName = "Amit Shekhar"
        developerAge = 22
    }
}

fun getPersonFromDeveloper(developer: Developer): Person {
    return with(developer) {
        Person(developerName, developerAge)
    }
}