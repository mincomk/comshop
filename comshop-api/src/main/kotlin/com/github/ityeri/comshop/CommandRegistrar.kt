package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar


object CommandRegistrar : AbstractCommandRegistrar by ComshopLoader.loadRegistrarImpl()