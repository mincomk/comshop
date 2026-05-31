package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.CommandSourceStack

class NodeBoundary(
    val entries: Collection<UnionArgumentBuilder>,
    val exits: Collection<UnionArgumentBuilder>,
    val pendingCommand: Command<CommandSourceStack>? = null
) {
}
