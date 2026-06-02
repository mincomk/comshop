package com.github.ityeri.comshop.internal.impl.converter.argument

import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.github.ityeri.comshop.internal.argument.StringType
import com.mojang.brigadier.arguments.*


fun <T : Any> NativeArgumentType<T>.toBrigadierArgumentType(): ArgumentType<T> =
    when (this) {
        is NativeArgumentType.BooleanArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            BoolArgumentType.bool() as ArgumentType<T>
        }
        is NativeArgumentType.IntArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            IntegerArgumentType.integer(this.min, this.max) as ArgumentType<T>
        }
        is NativeArgumentType.FloatArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            FloatArgumentType.floatArg(this.min, this.max) as ArgumentType<T>
        }
        is NativeArgumentType.DoubleArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            DoubleArgumentType.doubleArg(this.min, this.max) as ArgumentType<T>
        }
        is NativeArgumentType.LongArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            LongArgumentType.longArg(this.min, this.max) as ArgumentType<T>
        }
        is NativeArgumentType.StringArgumentType -> {
            @Suppress("UNCHECKED_CAST")
            when (this.type) {
                StringType.WORD -> StringArgumentType.word()
                StringType.QUOTED -> StringArgumentType.string()
                StringType.GREEDY -> StringArgumentType.greedyString()
            } as ArgumentType<T>
        }
    }
