package com.github.ityeri.comshop.internal.impl.converter

import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.impl.CommandFragment
import com.github.ityeri.comshop.internal.impl.CommandNodeBuilder
import com.github.ityeri.comshop.internal.impl.converter.argument.toBrigadierArgumentType
import com.github.ityeri.comshop.internal.impl.optic.nodePTraversal
import com.github.ityeri.comshop.internal.node.ComshopCommandNode
import com.github.ityeri.comshop.internal.node.Node


fun toCommandFragmentNode(node: Node<ComshopCommandNode>): Node<CommandFragment> =
    nodePTraversal<ComshopCommandNode, CommandFragment>()
        .modify(
            node,
            { commandNode ->
                toCommandFragment(commandNode)
            }
        )

fun toCommandFragment(commandNode: ComshopCommandNode): CommandFragment =
    when (commandNode) {
        is ComshopCommandNode.LiteralCommandNode -> {
            CommandFragment.NodeBuilderFragment(
                CommandNodeBuilder.LiteralNodeBuilder(
                    commandNode.name, commandNode.requiresChecker
                )
            )
        }
        is ComshopCommandNode.ArgumentNode<*> -> {
            CommandFragment.NodeBuilderFragment(
                CommandNodeBuilder.ArgumentNodeBuilder(
                    commandNode.name,
                    argumentType = commandNode.argumentType.toBrigadierArgumentType(),
                    requiresChecker =  commandNode.requiresChecker,
                    suggestionProvider =  commandNode.customSuggestionProvider?.let { provider ->
                        toBrigadierSuggestionProvider(provider)
                    }
                )
            )
        }
        is ComshopCommandNode.ExecutionNode -> {
            CommandFragment.ExecutionFragment { ctx ->
                 commandNode.commandBlock(
                    object : ComshopContext {
                        override val source = ctx.source

                        override fun <T> getArgument(name: String, clazz: Class<T>): T {
                            return ctx.getArgument(name, clazz)
                        }
                    }
                ).toInt()
            }
        }
    }
