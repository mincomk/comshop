package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractComshopFactory
import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType
import com.github.ityeri.comshop.internal.node.type.AbstractCommandNodeType
import com.mojang.brigadier.context.CommandContext

class ComshopFactoryImpl : AbstractComshopFactory {
    override fun <S> createCommandNodeType(
        literal: String,
        commandBlock: (CommandContext<S>) -> Unit,
        permissionChecker: (S) -> Boolean
    ): AbstractCommandNodeType<S> {
        TODO("Not yet implemented")
    }

    override fun <S, T> createArgumentNodeType(
        name: String,
        argumentType: ComshopArgumentType<T>
    ): AbstractArgumentNodeType<S, T> {
        TODO("Not yet implemented")
    }
}