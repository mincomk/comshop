package com.github.ityeri.comshop.internal.node

import com.github.ityeri.comshop.internal.CommandResult
import com.github.ityeri.comshop.internal.CommandWritingContext
import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.SuggestionElement
import io.papermc.paper.command.brigadier.CommandSourceStack


sealed class ComshopCommandNode {
    class LiteralCommandNode(
        val name: String,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true },
    ) : ComshopCommandNode()

    class ArgumentNode<T>(
        val name: String,
        val argumentType: ComshopArgumentType<T>,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true },
        val customSuggestionProvider: (CommandWritingContext, CommandSourceStack) -> Iterable<SuggestionElement> =
            { _, _ -> emptyList() },
        val onlyCustomSuggestions: Boolean = false
    ) : ComshopCommandNode()

    class ExecutionNode(
        val commandBlock: (ComshopContext) -> CommandResult
    ) : ComshopCommandNode()
}
