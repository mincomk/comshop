package com.github.ityeri.comshop.internal.node.type

import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import io.papermc.paper.command.brigadier.CommandSourceStack

sealed class CommandNodeType {
    class LiteralCommandNode(
        val name: String,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true }
    ) : CommandNodeType()

    class ArgumentNode<T>(
        val argumentType: ComshopArgumentType<T>,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true }
    ) : CommandNodeType()

    class ExecuteNode(block: (ComshopContext) -> Unit) : CommandNodeType()
}
