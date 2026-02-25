package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.entry.AbstractComshopLoader

internal object ComshopBootstrapper {
    var loaderClassPath: String = "com.github.ityeri.comshop.internal.impl.ComshopLoaderImpl"
    var loader: AbstractComshopLoader? = null

    fun load() {
        try {
            val clazz = Class.forName(loaderClassPath)
            loader = clazz.getDeclaredConstructor().newInstance() as AbstractComshopLoader
        } catch (e: ClassNotFoundException) {
            throw ClassNotFoundException("loaderClassPath invalid or cannot find loader class")
        }
    }
}