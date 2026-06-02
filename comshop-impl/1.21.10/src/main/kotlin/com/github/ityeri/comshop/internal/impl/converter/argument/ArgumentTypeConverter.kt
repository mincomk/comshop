package com.github.ityeri.comshop.internal.impl.converter.argument

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.ComshopCustomArgumentType
import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.mojang.brigadier.arguments.ArgumentType


fun <T : Any> ComshopArgumentType<T>.toBrigadierArgumentType(): ArgumentType<T> =
    when (this) {
        is NativeArgumentType -> {
            toBrigadierArgumentType()
        }
        is ComshopCustomArgumentType<T, *> -> {
            toBrigadierArgumentType()
        }
        else -> {
            throw IllegalArgumentException("Unexpected ComshopArgumentTypes's subtype was passed")
        }
    }
