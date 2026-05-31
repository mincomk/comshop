package com.github.ityeri.comshop.internal.node.type

import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import io.papermc.paper.command.brigadier.CommandSourceStack

sealed class ComshopCommandNode {
    class LiteralCommandNode(
        val name: String,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true },
        val commandBlock: (ComshopContext) -> Unit
    ) : ComshopCommandNode()

    class ArgumentNode<T>(
        val name: String,
        val argumentType: ComshopArgumentType<T>,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true }
    ) : ComshopCommandNode()
}
