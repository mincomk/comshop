package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import com.github.ityeri.comshop.internal.entry.StringType
import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.arguments.BoolArgumentType
import com.mojang.brigadier.arguments.DoubleArgumentType
import com.mojang.brigadier.arguments.FloatArgumentType
import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.arguments.LongArgumentType
import com.mojang.brigadier.arguments.StringArgumentType

class PrimitiveTypesImpl : AbstractPrimitiveTypes {
    override fun bool(): ComshopArgumentType<Boolean> =
        object : ComshopArgumentType<Boolean> {
            override fun build(): ArgumentType<Boolean> = BoolArgumentType.bool()
        }

    override fun int(min: Int, max: Int): ComshopArgumentType<Int> =
        object : ComshopArgumentType<Int> {
            override fun build(): ArgumentType<Int> = IntegerArgumentType.integer(min, max)
        }

    override fun float(min: Float, max: Float): ComshopArgumentType<Float> =
        object : ComshopArgumentType<Float> {
            override fun build(): ArgumentType<Float> = FloatArgumentType.floatArg(min, max)
        }

    override fun double(min: Double, max: Double): ComshopArgumentType<Double> =
        object : ComshopArgumentType<Double> {
            override fun build(): ArgumentType<Double> = DoubleArgumentType.doubleArg(min, max)
        }

    override fun long(min: Long, max: Long): ComshopArgumentType<Long> =
        object : ComshopArgumentType<Long> {
            override fun build(): ArgumentType<Long> = LongArgumentType.longArg(min, max)
        }

    override fun string(type: StringType): ComshopArgumentType<String> =
        object : ComshopArgumentType<String> {
            override fun build(): ArgumentType<String> =
                when (type) {
                    StringType.WORD -> StringArgumentType.word()
                    StringType.QUOTED -> StringArgumentType.string()
                    StringType.GREEDY -> StringArgumentType.greedyString()
                }
        }
}