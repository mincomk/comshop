package com.github.ityeri.comshop.internal.node.type

import com.mojang.brigadier.context.CommandContext

interface AbstractCommandNodeType<S> : NodeType<S> {
    val name: String
    val commandBlock: (source: CommandContext<S>) -> Unit
    val permissionChecker: (source: S) -> Boolean
}