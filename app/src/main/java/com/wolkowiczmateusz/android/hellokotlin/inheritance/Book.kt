package com.wolkowiczmateusz.android.hellokotlin.inheritance

open class Book(var title: String, var author: String) {

    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }

}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}