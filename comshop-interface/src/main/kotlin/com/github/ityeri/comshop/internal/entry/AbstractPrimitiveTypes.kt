package com.github.ityeri.comshop.internal.entry

interface AbstractPrimitiveTypes {
    fun bool(): ComshopArgumentType<Boolean>
    fun int(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): ComshopArgumentType<Int>
    fun float(min: Float = Float.MIN_VALUE, max: Float = Float.MAX_VALUE): ComshopArgumentType<Float>
    fun double(min: Double = Double.MIN_VALUE, max: Double = Double.MAX_VALUE): ComshopArgumentType<Double>
    fun long(min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE): ComshopArgumentType<Long>
    fun string(type: StringType = StringType.WORD): ComshopArgumentType<String>
}

enum class StringType {
    WORD,
    QUOTED,
    GREEDY
}