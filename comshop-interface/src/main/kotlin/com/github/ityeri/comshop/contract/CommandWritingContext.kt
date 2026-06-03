package com.github.ityeri.comshop.contract

class CommandWritingContext(val fullInput: String, val start: Int) {
    val remining: String
        get() = fullInput.substring(start)
    val reminingLower: String
        get() = remining.lowercase()
}
