package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.entry.AbstractComshopFactory
import com.github.ityeri.comshop.internal.entry.AbstractComshopLoader
import com.github.ityeri.comshop.internal.entry.AbstractPaperTypes
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes
import io.papermc.paper.command.brigadier.CommandSourceStack

class ComshopLoaderImpl : AbstractComshopLoader {
    override fun loadFactory(): AbstractComshopFactory {
        TODO("Not yet implemented")
    }

    override fun loadRegistrar(): AbstractCommandRegistrar<CommandSourceStack> {
        TODO("Not yet implemented")
    }

    override fun loadPrimitiveTypes(): AbstractPrimitiveTypes {
        TODO("Not yet implemented")
    }

    override fun loadPaperTypes(): AbstractPaperTypes {
        TODO("Not yet implemented")
    }
}