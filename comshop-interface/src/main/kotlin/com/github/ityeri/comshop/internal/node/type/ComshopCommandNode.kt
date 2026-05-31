package com.github.ityeri.comshop.internal.node.type

import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import io.papermc.paper.command.brigadier.CommandSourceStack

sealed class ComshopCommandNode {
    class LiteralComshopCommandNode(
        val name: String,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true }
    ) : ComshopCommandNode()

    class ArgumentNodeComshop<T>(
        val argumentType: ComshopArgumentType<T>,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true }
    ) : ComshopCommandNode()

    class ExecuteNodeComshop(block: (ComshopContext) -> Unit) : ComshopCommandNode()
}
