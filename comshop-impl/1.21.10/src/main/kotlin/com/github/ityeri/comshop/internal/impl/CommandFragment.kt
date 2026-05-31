package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import com.mojang.brigadier.builder.ArgumentBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack


sealed class CommandFragment {
    class ArgumentFragment<
            T : ArgumentBuilder<CommandSourceStack, T>
            >(val builder: ArgumentBuilder<CommandSourceStack, T>) : CommandFragment()
    class ExecutionFragment(val command: Command<CommandSourceStack>) : CommandFragment()
}
