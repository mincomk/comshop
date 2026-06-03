package com.github.ityeri.comshop.builder

import com.github.ityeri.comshop.contract.argument.NativeArgumentType
import com.github.ityeri.comshop.contract.argument.StringType


open class ArgumentNodeBuilderFactory {
    fun <T : Any> fromNativeType(
        argumentType: NativeArgumentType<T>
    ): ArgumentStructureBuilder.SingleNodeBuilder<T> =
        ArgumentStructureBuilder.SingleNodeBuilder(
            null, argumentType
        )

    fun boolean() = fromNativeType(NativeArgumentType.BooleanArgumentType())

    fun int(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE) =
        fromNativeType(NativeArgumentType.IntArgumentType(min, max))

    fun float(min: Float = Float.MIN_VALUE, max: Float = Float.MAX_VALUE) =
        fromNativeType(NativeArgumentType.FloatArgumentType(min, max))

    fun double(min: Double = Double.MIN_VALUE, max: Double = Double.MAX_VALUE) =
        fromNativeType(NativeArgumentType.DoubleArgumentType(min, max))

    fun long(min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE) =
        fromNativeType(NativeArgumentType.LongArgumentType(min, max))

    fun string(type: StringType) = fromNativeType(NativeArgumentType.StringArgumentType(type))
    fun word() = fromNativeType(NativeArgumentType.StringArgumentType(StringType.WORD))
    fun quotedString() = fromNativeType(NativeArgumentType.StringArgumentType(StringType.QUOTED))
    fun greedyString() = fromNativeType(NativeArgumentType.StringArgumentType(StringType.GREEDY))
}
