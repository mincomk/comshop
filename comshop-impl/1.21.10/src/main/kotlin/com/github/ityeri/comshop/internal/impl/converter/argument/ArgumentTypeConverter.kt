package com.github.ityeri.comshop.internal.impl.converter.argument

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.ComshopCustomArgumentType
import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.mojang.brigadier.arguments.ArgumentType


fun <T : Any> convertToArgumentType(argumentType: ComshopArgumentType<T>): ArgumentType<T> =
    when (argumentType) {
        is NativeArgumentType -> {
            convertNativeArgumentType(argumentType)
        }
        is ComshopCustomArgumentType<T, *> -> {
            convertCustomArgumentWrap<T, Any>(argumentType)
        }
        else -> {
            throw IllegalArgumentException("Unexpected ComshopArgumentTypes's subtype was passed")
        }
    }

private fun <T : Any, N: Any> convertCustomArgumentWrap(argumentType: ComshopCustomArgumentType<T, *>): ArgumentType<T> =
    @Suppress("UNCHECKED_CAST")
    convertCustomArgumentType(argumentType as ComshopCustomArgumentType<T, N>)
