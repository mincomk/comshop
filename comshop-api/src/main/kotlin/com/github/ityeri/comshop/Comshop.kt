package com.github.ityeri.comshop

import com.github.ityeri.comshop.dsl.LiteralCommandDSL
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.NodeType
import io.papermc.paper.command.brigadier.CommandSourceStack

fun command(name: String, block: LiteralCommandDSL.() -> Unit): Node<NodeType<CommandSourceStack>> {
    val dsl = LiteralCommandDSL(name).apply(block)
    return dsl.build()
}