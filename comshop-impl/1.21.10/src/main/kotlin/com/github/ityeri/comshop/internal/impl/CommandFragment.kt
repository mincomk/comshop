package com.github.ityeri.comshop.internal.impl

import com.mojang.brigadier.Command
import com.mojang.brigadier.builder.RequiredArgumentBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack


sealed class CommandFragment {
    class ArgumentFragment<T>(val builder: RequiredArgumentBuilder<CommandSourceStack, T>) : CommandFragment()
    class ExecutionFragment(val command: Command<CommandSourceStack>) : CommandFragment()
}
