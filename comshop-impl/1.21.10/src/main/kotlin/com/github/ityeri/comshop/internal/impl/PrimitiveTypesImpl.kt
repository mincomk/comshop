package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import com.github.ityeri.comshop.internal.entry.StringType

class PrimitiveTypesImpl : AbstractPrimitiveTypes {
    override fun bool(): ComshopArgumentType<Boolean> = TODO()
    override fun int(min: Int, max: Int): ComshopArgumentType<Int> = TODO()
    override fun float(min: Float, max: Float): ComshopArgumentType<Float> = TODO()
    override fun double(min: Double, max: Double): ComshopArgumentType<Double> = TODO()
    override fun long(min: Long, max: Long): ComshopArgumentType<Long> = TODO()
    override fun string(type: StringType): ComshopArgumentType<String> = TODO()
}