package com.github.ityeri.comshop.internal.entry

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import io.papermc.paper.command.brigadier.CommandSourceStack

interface AbstractComshopLoader {
    fun loadFactory(): AbstractComshopFactory
    fun loadRegistrar(): AbstractCommandRegistrar<CommandSourceStack>

    fun loadPrimitiveTypes(): AbstractPrimitiveTypes
    fun loadPaperTypes(): AbstractPaperTypes
}