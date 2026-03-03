package com.github.ityeri.comshop.argument

import com.github.ityeri.comshop.ComshopBootstrapper
import com.github.ityeri.comshop.internal.entry.AbstractPaperTypes

object PaperTypes : AbstractPaperTypes by ComshopBootstrapper.loader!!.loadPaperTypes()