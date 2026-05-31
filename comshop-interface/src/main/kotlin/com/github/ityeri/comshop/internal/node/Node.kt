package com.github.ityeri.comshop.internal.node

sealed class Node<out T> {
    class SingleNode<T>(val value: T) : Node<T>()
    class UnionNode<T>(val nodes: Iterable<Node<T>>) : Node<T>()
    class ChainNode<T>(val nodes: Iterable<Node<T>>) : Node<T>()
}
