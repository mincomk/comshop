package com.github.ityeri.comshop.argument

import com.github.ityeri.comshop.ComshopBootstrapper
import com.github.ityeri.comshop.internal.entry.AbstractPrimitiveTypes

object PrimitiveTypes : AbstractPrimitiveTypes by ComshopBootstrapper.loader!!.loadPrimitiveTypes()