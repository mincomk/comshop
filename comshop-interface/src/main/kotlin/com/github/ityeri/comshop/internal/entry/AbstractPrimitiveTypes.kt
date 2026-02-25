package com.github.ityeri.comshop.internal.entry

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType

interface AbstractPrimitiveTypes {
    fun bool(): ComshopArgumentType<Boolean>
    fun int(): ComshopArgumentType<Int>
    fun float(): ComshopArgumentType<Float>
    fun double(): ComshopArgumentType<Double>
    fun long(): ComshopArgumentType<Long>
    fun string(type: StringType = StringType.WORD): ComshopArgumentType<String>
}

enum class StringType {
    WORD,
    QUOTED,
    GREEDY
}