package com.github.ityeri.comshop.internal.impl.converter.argument

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.ComshopCustomArgumentType
import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.mojang.brigadier.arguments.ArgumentType


fun <T> convertToArgumentType(argumentType: ComshopArgumentType<T>): ArgumentType<T> =
    when (argumentType) {
        is NativeArgumentType -> {
            convertNativeArgumentType(argumentType)
        }
        is ComshopCustomArgumentType<T, *> -> {
            convertCustomArgumentWrap(argumentType)
        }
        else -> {
            throw IllegalArgumentException("Unexpected ComshopArgumentTypes's subtype was passed")
        }
    }

fun <T, N> convertCustomArgumentWrap(argumentType: ComshopCustomArgumentType<T, N>): ArgumentType<T> {
    return convertCustomArgumentWrap(argumentType)
}
