package com.github.ityeri.comshop.internal.node.type

import com.mojang.brigadier.builder.ArgumentBuilder

interface NodeType<S> {
    fun createBuilder(): ArgumentBuilder<S, *>
}