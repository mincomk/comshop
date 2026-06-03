package com.github.ityeri.comshop.contract

import io.papermc.paper.command.brigadier.CommandSourceStack

interface ComshopContext {
    val source: CommandSourceStack
    fun <T> getArgument(name: String, clazz: Class<T>): T
}
