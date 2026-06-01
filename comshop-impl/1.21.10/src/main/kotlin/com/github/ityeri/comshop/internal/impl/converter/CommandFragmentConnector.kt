package com.github.ityeri.comshop.internal.impl.converter

import com.github.ityeri.comshop.internal.impl.CommandFragment
import com.github.ityeri.comshop.internal.impl.CommandTreeBoundary
import com.github.ityeri.comshop.internal.impl.nodePTraversal
import com.github.ityeri.comshop.internal.node.Node


fun connectCommandFragments(node: Node<CommandFragment>): CommandTreeBoundary =
    connectCommendTreeBoundaries(
        nodePTraversal<CommandFragment, CommandTreeBoundary>()
            .modify(node, { fragment ->
                when (fragment) {
                    is CommandFragment.NodeBuilderFragment -> {
                        CommandTreeBoundary(listOf(fragment.builder), listOf(fragment.builder))
                    }
                    is CommandFragment.ExecutionFragment -> {
                        CommandTreeBoundary(
                            entries = emptyList(),
                            exits = emptyList(),
                            pendingCommand = fragment.command
                        )
                    }
                }
            })
    )

fun connectCommendTreeBoundaries(node: Node<CommandTreeBoundary>): CommandTreeBoundary =
    when (node) {
        is Node.SingleNode -> {
            node.value
        }
        is Node.UnionNode -> {
            val boundaries = node.nodes.map { connectCommendTreeBoundaries(it) }

            CommandTreeBoundary(
                boundaries.flatMap { it.entries },
                boundaries.flatMap { it.exits }
            )
        }
        is Node.ChainNode -> {
            connectBoundaryChain(
                node.nodes.map { connectCommendTreeBoundaries(it) }
            )
        }
    }

fun connectBoundaryChain(
    boundaries: List<CommandTreeBoundary>
): CommandTreeBoundary =
    if (boundaries.isEmpty()) {
        CommandTreeBoundary(listOf(), listOf())
    } else if (boundaries.size == 1) {
        boundaries.first()
    } else {
        val headBoundary = boundaries.first()
        val bodyBoundary = connectBoundaryChain(boundaries.subList(1, boundaries.size))

        headBoundary.connectNext(bodyBoundary)
    }
