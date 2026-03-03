package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.entry.AbstractComshopLoader

object ComshopBootstrapper {
    var loaderClassPath: String = "com.github.ityeri.comshop.internal.impl.ComshopLoaderImpl"
    internal var loader: AbstractComshopLoader? = null
        get() = if (field != null) {
            field
        } else {
            throw IllegalStateException("Loader is not loaded yet. Please call ComshopBootstrapper.load() first")
        }

    fun load() {
        try {
            val clazz = Class.forName(loaderClassPath)
            loader = clazz.getDeclaredConstructor().newInstance() as AbstractComshopLoader
        } catch (e: ClassNotFoundException) {
            throw ClassNotFoundException(
                "loaderClassPath is invalid or cannot find loader class. Is comshop impl dependency added?"
            )
        }
    }
}