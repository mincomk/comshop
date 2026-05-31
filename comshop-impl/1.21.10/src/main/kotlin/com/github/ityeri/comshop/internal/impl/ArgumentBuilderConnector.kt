package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.node.Node
import com.mojang.brigadier.builder.ArgumentBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack


fun connectArgumentBuilders(node: Node<UnifiedArgumentBuilder>): NodeBoundary<UnifiedArgumentBuilder> {
    return when (node) {
        is Node.SingleNode -> {
            NodeBoundary(listOf(node.value), listOf(node.value))
        }
        is Node.ChainNode -> {
            connectBoundaryChain(node.nodes.map { connectArgumentBuilders(it) })
        }
        is Node.UnionNode -> {
            val builders = node.nodes.map { connectArgumentBuilders(it) }
            NodeBoundary(
                builders.flatMap { it.entries },
                builders.flatMap { it.exits }
            )
        }
    }
}

fun connectBoundaryChain(
    boundaries: List<NodeBoundary<UnifiedArgumentBuilder>>
): NodeBoundary<ArgumentBuilder<CommandSourceStack, *>> {
    return if (boundaries.isEmpty()) {
        NodeBoundary(listOf(), listOf())
    } else if (boundaries.size == 1) {
        boundaries[0]
    } else {
        val headBoundary = boundaries[0]
        val endBoundary = connectBoundaryChain(boundaries.subList(1, boundaries.size))

        for (lastExit in headBoundary.exits) {
            for (nextEntry in endBoundary.entries) {
                lastExit.then(nextEntry)
            }
        }

        NodeBoundary(headBoundary.entries, endBoundary.exits)
    }
}
