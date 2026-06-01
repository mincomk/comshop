package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.CommandSourceStack


sealed class CommandFragment {
    class NodeBuilderFragment(val builder: CommandNodeBuilder) : CommandFragment()
    class ExecutionFragment(val command: Command<CommandSourceStack>) : CommandFragment()
}
