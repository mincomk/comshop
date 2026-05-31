package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.CommandSourceStack

class CommandTreeBoundary(
    val entries: Collection<UnionArgumentBuilder>,
    val exits: Collection<UnionArgumentBuilder>,
    val pendingCommand: Command<CommandSourceStack>? = null
) {
    val onlyExecutionFragment: Boolean
        get() = pendingCommand != null && exits.isEmpty()

    fun connectNext(boundary: CommandTreeBoundary): CommandTreeBoundary {
        exits.forEach { exitBuilder ->
            boundary.entries.forEach { entryBuilder ->
                exitBuilder.then(entryBuilder)
            }
        }

        if (boundary.pendingCommand != null) {
            exits.forEach { it.executes(boundary.pendingCommand) }
        }

        return CommandTreeBoundary(
            entries,
            if (boundary.onlyExecutionFragment) exits else boundary.exits
        )
    }
}
