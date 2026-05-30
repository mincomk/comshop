package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder

class ArgumentNodeType<S, T>(
    override val name: String,
    override val argumentType: ComshopArgumentType<T>
) : AbstractArgumentNodeType<S, T> {
    override fun createBuilder(): ArgumentBuilder<S, *> {
        return RequiredArgumentBuilder.argument<S, T>(name, argumentType.build())
    }
}
