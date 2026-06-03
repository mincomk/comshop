package com.github.ityeri.comshop.contract.node

import com.github.ityeri.comshop.contract.CommandResult
import com.github.ityeri.comshop.contract.CommandWritingContext
import com.github.ityeri.comshop.contract.ComshopContext
import com.github.ityeri.comshop.contract.argument.ComshopArgumentType
import com.github.ityeri.comshop.contract.argument.SuggestionElement
import io.papermc.paper.command.brigadier.CommandSourceStack


typealias CustomSuggestionProvider = (CommandWritingContext, CommandSourceStack) -> Iterable<SuggestionElement>

sealed class ComshopCommandNode {
    class LiteralCommandNode(
        val name: String,
        val requiresChecker: (CommandSourceStack) -> Boolean = { true },
    ) : ComshopCommandNode()

    class ArgumentNode<T : Any>(
        val name: String,
        val argumentType: ComshopArgumentType<T>,
        val requiresChecker: (CommandSourceStack) -> Boolean = { _ -> true },
        val customSuggestionProvider: CustomSuggestionProvider? = null
    ) : ComshopCommandNode()

    class ExecutionNode(
        val commandBlock: (ComshopContext) -> CommandResult
    ) : ComshopCommandNode()
}
