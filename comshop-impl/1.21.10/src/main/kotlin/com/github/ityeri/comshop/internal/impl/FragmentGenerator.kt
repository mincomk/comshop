package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.ComshopContext
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.argument.ComshopCustomArgumentType
import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.ComshopCommandNode
import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack


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
                    convertToArgumentType(commandNode.argumentType),
                    commandNode.requiresChecker,
                    null // TODO after suggestion feature implemented
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
                )

                0
            }
        }
    }
