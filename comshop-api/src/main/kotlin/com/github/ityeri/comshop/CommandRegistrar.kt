package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import io.papermc.paper.command.brigadier.CommandSourceStack

object CommandRegistrar : AbstractCommandRegistrar<CommandSourceStack> by ComshopBootstrapper.loader!!.loadRegistrar()