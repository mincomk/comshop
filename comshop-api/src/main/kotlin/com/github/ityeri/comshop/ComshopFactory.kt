package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.entry.AbstractComshopFactory

object ComshopFactory : AbstractComshopFactory by ComshopBootstrapper.loader!!.loadFactory()