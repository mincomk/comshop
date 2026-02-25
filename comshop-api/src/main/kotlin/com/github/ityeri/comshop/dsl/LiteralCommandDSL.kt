package com.github.ityeri.comshop.dsl

import com.github.ityeri.comshop.CommandNodeType
import com.github.ityeri.comshop.internal.node.ChainNode
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.SingleNode
import com.github.ityeri.comshop.internal.node.UnionNode
import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType
import com.github.ityeri.comshop.internal.node.type.NodeType
import io.papermc.paper.command.brigadier.CommandSourceStack
import org.bukkit.command.CommandSender


@ComshopDSL
class LiteralCommandDSL(val name: String) {
    private val argumentChains: MutableList<ChainNode<AbstractArgumentNodeType<CommandSourceStack, *>>> = mutableListOf()
    private val subNodes: MutableList<Node<NodeType<CommandSourceStack>>> = mutableListOf()
    private var executor:
            ContextDSL<CommandSourceStack>.(source: CommandSourceStack, sender: CommandSender) -> Unit =
        { _, _  -> }
    private var permissionChecker: (source: CommandSourceStack) -> Boolean = { true }

    fun requires(block: (source: CommandSourceStack) -> Boolean) {
        permissionChecker = block
    }

    fun arguments(block: ArgumentListDSL<CommandSourceStack>.() -> Unit) {
        val dsl = ArgumentListDSL<CommandSourceStack>().apply(block)
        argumentChains.add(dsl.buildChainNode())
    }

    fun executes(
        block: ContextDSL<CommandSourceStack>.(source: CommandSourceStack, sender: CommandSender) -> Unit
    ) {
        executor = block
    }

    fun then(name: String, block: LiteralCommandDSL.() -> Unit) {
        val dsl = LiteralCommandDSL(name).apply(block)
        subNodes.add(dsl.build())
    }
    fun then(node: Node<NodeType<CommandSourceStack>>) {
        subNodes.add(node)
    }

    fun build(): Node<NodeType<CommandSourceStack>> {
        return ChainNode(listOf(
            SingleNode(
                CommandNodeType(
                    name,
                    { context ->
                        val dsl = ContextDSL(context)
                        dsl.executor(context.source, context.source.sender)
                    },
                    permissionChecker
                )
            ),
            UnionNode(
                subNodes + argumentChains
            )
        ))
    }
}
