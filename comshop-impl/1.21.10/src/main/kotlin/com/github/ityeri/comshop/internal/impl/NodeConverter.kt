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


fun convertToArgumentBuilderNode(node: Node<ComshopCommandNode>): Node<UnionArgumentBuilder> =
    nodePTraversal<ComshopCommandNode, UnionArgumentBuilder>()
        .modify(
            node,
            { commandNode ->
                convertToArgumentBuilder(commandNode)
            }
        )

fun convertToArgumentBuilder(commandNode: ComshopCommandNode): UnionArgumentBuilder =
    when (commandNode) {
        is ComshopCommandNode.LiteralCommandNode -> {
            LiteralArgumentBuilder
                .literal<CommandSourceStack>(commandNode.name)
                .requires(commandNode.requiresChecker)
        }
        is ComshopCommandNode.ArgumentNode<*> -> {
            convertToArgumentBuilder(commandNode)
        }
        is ComshopCommandNode.ExecuteNode -> {
            LiteralArgumentBuilder
                .literal<CommandSourceStack>("EOC")
                .executes { ctx ->
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

fun <T> convertToArgumentBuilder(commandNode: ComshopCommandNode.ArgumentNode<T>): RequiredArgumentBuilder<CommandSourceStack, T> =
    RequiredArgumentBuilder.argument<CommandSourceStack, T>(
        commandNode.name,
        convertToArgumentType(commandNode.argumentType)
    ).requires(commandNode.requiresChecker)

fun <T> convertToArgumentType(argumentType: ComshopArgumentType<T>): ArgumentType<T> =
    when (argumentType) {
        is NativeArgumentType -> {
            convertNativeArgumentType(argumentType)
        }
        is ComshopCustomArgumentType<T, *> -> {
            TODO()
        }
        else -> {
            throw IllegalArgumentException("Unexpected ComshopArgumentTypes's subtype was passed")
        }
    }
