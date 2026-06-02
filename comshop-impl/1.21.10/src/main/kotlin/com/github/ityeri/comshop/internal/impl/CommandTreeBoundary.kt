package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.CommandSourceStack


class CommandTreeBoundary(
    val entries: Collection<BrigadierNodeBuilder>,
    val exits: Collection<BrigadierNodeBuilder>,
    val pendingCommand: Command<CommandSourceStack>? = null
) {
    val onlyExecutionFragment: Boolean
        get() = pendingCommand != null && exits.isEmpty()

    fun connectNext(boundary: CommandTreeBoundary): CommandTreeBoundary {
        exits.forEach { exitBuilder ->
            boundary.entries.forEach { entryBuilder ->
                exitBuilder.children.add(entryBuilder)
            }
        }

        if (boundary.pendingCommand != null) {
            exits.forEach { it.command = boundary.pendingCommand }
        }

        return CommandTreeBoundary(
            entries,
            if (boundary.onlyExecutionFragment) exits else boundary.exits
        )
    }
}
