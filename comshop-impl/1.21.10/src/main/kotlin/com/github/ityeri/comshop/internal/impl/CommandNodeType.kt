package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.node.type.AbstractCommandNodeType
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext

class CommandNodeType<S>(
    override val name: String,
    override val commandBlock: (CommandContext<S>) -> Unit,
    override val permissionChecker: (S) -> Boolean
) : AbstractCommandNodeType<S> {
    override fun createBuilder(): ArgumentBuilder<S, *> {
        val builder = LiteralArgumentBuilder.literal<S>(name)
        builder.executes { context -> commandBlock(context); 0 }
        builder.requires(permissionChecker)

        return builder
    }
}