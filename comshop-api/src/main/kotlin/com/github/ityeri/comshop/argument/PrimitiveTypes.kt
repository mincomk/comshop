package com.github.ityeri.comshop.argument

import com.github.ityeri.comshop.ComshopBootstrapper
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import com.github.ityeri.comshop.internal.entry.StringType

object PrimitiveTypes : AbstractPrimitiveTypes {
    private val types = ComshopBootstrapper.loader!!.loadPrimitiveTypes()

    override fun bool(): ComshopArgumentType<Boolean> = types.bool()
    override fun int(min: Int, max: Int): ComshopArgumentType<Int> = types.int(min, max)
    override fun float(min: Float, max: Float): ComshopArgumentType<Float> = types.float(min, max)
    override fun double(min: Double, max: Double): ComshopArgumentType<Double> = types.double(min, max)
    override fun long(min: Long, max: Long): ComshopArgumentType<Long> = types.long(min, max)
    override fun string(type: StringType): ComshopArgumentType<String> = types.string(type)
}
