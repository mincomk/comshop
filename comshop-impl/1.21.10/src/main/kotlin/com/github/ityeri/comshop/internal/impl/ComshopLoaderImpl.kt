package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.argument.AbstractCustomArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.entry.AbstractComshopFactory
import com.github.ityeri.comshop.internal.entry.AbstractComshopLoader
import com.github.ityeri.comshop.internal.entry.AbstractPaperTypes
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import io.papermc.paper.command.brigadier.CommandSourceStack

class ComshopLoaderImpl : AbstractComshopLoader {
    override fun loadFactory(): AbstractComshopFactory {
        return ComshopFactoryImpl()
    }

    override fun loadRegistrar(): AbstractCommandRegistrar<CommandSourceStack> {
        return CommandRegistrarImpl()
    }

    override fun <T, N> loadCustomArgumentType(): AbstractCustomArgumentType<T, N> {
        TODO()
    }

    override fun loadPrimitiveTypes(): AbstractPrimitiveTypes {
        TODO("Not yet implemented")
    }

    override fun loadPaperTypes(): AbstractPaperTypes {
        TODO("Not yet implemented")
    }
}