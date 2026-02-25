package com.github.ityeri.comshop.internal.node.type

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType

interface AbstractArgumentNodeType<S, T> : NodeType<S> {
    val name: String
    val argumentType: ComshopArgumentType<T>
}