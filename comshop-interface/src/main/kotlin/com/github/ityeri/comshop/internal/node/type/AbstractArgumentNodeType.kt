package com.github.ityeri.comshop.internal.node.type

interface AbstractArgumentNodeType<S, T> : NodeType<S> {
    val name: String
    val argumentType: ComshopArgumentType<T>
}