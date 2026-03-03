package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.node.ChainNode
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.SingleNode
import com.github.ityeri.comshop.internal.node.UnionNode
import com.github.ityeri.comshop.internal.node.type.NodeType
import com.mojang.brigadier.builder.ArgumentBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack

fun createBoundary(node: Node<NodeType<CommandSourceStack>>): NodeBoundary<ArgumentBuilder<CommandSourceStack, *>> {
    return when (node) {
        is SingleNode -> {
            val builder = node.value.createBuilder()
            NodeBoundary(listOf(builder), listOf(builder))
        }
        is ChainNode -> {
            connectBoundaryChain(node.nodes.map { createBoundary(it) })
        }
        is UnionNode -> {
            val builders = node.nodes.map { createBoundary(it) }
            NodeBoundary(
                builders.flatMap { it.entries },
                builders.flatMap { it.exits }
            )
        }
        else -> {
            throw IllegalArgumentException("Unknown node is passed")
        }
    }
}

fun connectBoundaryChain(
    boundaries: List<NodeBoundary<ArgumentBuilder<CommandSourceStack, *>>>
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