package com.github.ityeri.comshop.argument

import com.github.ityeri.comshop.ComshopBootstrapper
import com.github.ityeri.comshop.internal.entry.AbstractPaperTypes

object PaperTypes : AbstractPaperTypes {
    val types = ComshopBootstrapper.loader!!.load
}