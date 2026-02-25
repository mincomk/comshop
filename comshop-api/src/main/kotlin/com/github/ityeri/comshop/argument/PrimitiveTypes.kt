package com.github.ityeri.comshop.argument

import com.github.ityeri.comshop.ComshopBootstrapper
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import com.github.ityeri.comshop.internal.entry.StringType

object PrimitiveTypes : AbstractPrimitiveTypes {
    private val types = ComshopBootstrapper.loader!!.loadPrimitiveTypes()

    override fun bool(): ComshopArgumentType<Boolean> = types.bool()
    override fun int(): ComshopArgumentType<Int> = types.int()
    override fun float(): ComshopArgumentType<Float> = types.float()
    override fun double(): ComshopArgumentType<Double> = types.double()
    override fun long(): ComshopArgumentType<Long> = types.long()
    override fun string(type: StringType): ComshopArgumentType<String> = types.string()
}
