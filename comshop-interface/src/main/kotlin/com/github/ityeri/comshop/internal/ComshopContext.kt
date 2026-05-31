package com.github.ityeri.comshop.internal

import io.papermc.paper.command.brigadier.CommandSourceStack
import org.bukkit.entity.Player

interface ComshopContext {
    val source: CommandSourceStack
    fun <T> getArgument(name: String, clazz: Class<T>): T
}
