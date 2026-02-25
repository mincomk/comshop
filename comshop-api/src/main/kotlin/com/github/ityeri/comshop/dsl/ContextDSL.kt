package com.github.ityeri.comshop.dsl

import com.mojang.brigadier.context.CommandContext
import kotlin.reflect.KClass

@ComshopDSL
class ContextDSL<S>(val context: CommandContext<S>) {
    infix fun <T: Any> String.to(clazz: KClass<T>): T {
        return context.getArgument<T>(this, clazz.java)
    }

    infix fun <T: Any> String.nullOr(clazz: KClass<T>): T? {
        return try {
            context.getArgument<T>(this, clazz.java)
        } catch (_: IllegalArgumentException) {
            null
        }
    }
}