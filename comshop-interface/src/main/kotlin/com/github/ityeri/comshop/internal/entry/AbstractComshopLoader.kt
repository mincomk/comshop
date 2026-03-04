package com.github.ityeri.comshop.internal.entry

import com.github.ityeri.comshop.internal.argument.AbstractCustomArgumentType
import io.papermc.paper.command.brigadier.CommandSourceStack

interface AbstractComshopLoader {
    fun loadFactory(): AbstractComshopFactory
    fun loadRegistrar(): AbstractCommandRegistrar<CommandSourceStack>
    fun <T, N> loadCustomArgumentType(): AbstractCustomArgumentType<T, N>

    fun loadPrimitiveTypes(): AbstractPrimitiveTypes
    fun loadPaperTypes(): AbstractPaperTypes
}