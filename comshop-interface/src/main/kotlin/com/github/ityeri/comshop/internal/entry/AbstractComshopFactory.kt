package com.github.ityeri.comshop.internal.entry

import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.AbstractCustomArgumentType
import com.github.ityeri.comshop.internal.node.type.AbstractCommandNodeType
import com.mojang.brigadier.context.CommandContext

interface AbstractComshopFactory {
    fun <S> createCommandNodeType(
        literal: String,
        commandBlock: (source: CommandContext<S>) -> Unit,
        permissionChecker: (source: S) -> Boolean
    ): AbstractCommandNodeType<S>
    fun <S, T> createArgumentNodeType(name: String, argumentType: ComshopArgumentType<T>):
            AbstractArgumentNodeType<S, T>
}