package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.CustomArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractComshopFactory
import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType
import com.github.ityeri.comshop.internal.node.type.AbstractCommandNodeType
import com.mojang.brigadier.context.CommandContext

object ComshopFactory : AbstractComshopFactory {
    private val factory = ComshopBootstrapper.loader!!.loadFactory()

    override fun <S> createCommandNodeType(
        literal: String,
        commandBlock: (CommandContext<S>) -> Unit,
        permissionChecker: (S) -> Boolean
    ): AbstractCommandNodeType<S> {
        return factory.createCommandNodeType(literal, commandBlock, permissionChecker)
    }
    override fun <S, T> createArgumentNodeType(
        name: String,
        argumentType: ComshopArgumentType<T>
    ): AbstractArgumentNodeType<S, T> {
        return factory.createArgumentNodeType(name, argumentType)
    }
    override fun <T> createCustomArgumentType(customArgumentType: CustomArgumentType<T>): ComshopArgumentType<T> {
        return factory.createCustomArgumentType(customArgumentType)
    }
}