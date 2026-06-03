package com.github.ityeri.comshop

import com.github.ityeri.comshop.contract.entry.AbstractCommandRegistrar


object CommandRegistrar : AbstractCommandRegistrar by ComshopLoader.loadRegistrarImpl()