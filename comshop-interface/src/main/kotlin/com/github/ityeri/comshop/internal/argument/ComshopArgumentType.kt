package com.github.ityeri.comshop.internal.argument

import com.mojang.brigadier.arguments.ArgumentType

interface ComshopArgumentType<T> {
    fun build(): ArgumentType<T>
}