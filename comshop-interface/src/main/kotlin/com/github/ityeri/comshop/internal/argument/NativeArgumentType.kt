package com.github.ityeri.comshop.internal.argument

sealed class NativeArgumentType<T : Any> : ComshopArgumentType<T> {
    // ArgumentType class's name prefix follows target generic type's class name (kotlin-side name first)

    class BooleanArgumentType : NativeArgumentType<Boolean>()

    class IntArgumentType(
        val min: Int = Int.MIN_VALUE,
        val max: Int = Int.MAX_VALUE
    ) : NativeArgumentType<Int>()

    class FloatArgumentType(
        val min: Float = Float.MIN_VALUE,
        val max: Float = Float.MAX_VALUE
    ) : NativeArgumentType<Float>()

    class DoubleArgumentType(
        val min: Double = Double.MIN_VALUE,
        val max: Double = Double.MAX_VALUE
    ) : NativeArgumentType<Double>()

    class LongArgumentType(
        val min: Long = Long.MIN_VALUE,
        val max: Long = Long.MAX_VALUE
    ) : NativeArgumentType<Long>()

    class StringArgumentType(
        val type: StringType = StringType.WORD
    ) : NativeArgumentType<String>()
}
