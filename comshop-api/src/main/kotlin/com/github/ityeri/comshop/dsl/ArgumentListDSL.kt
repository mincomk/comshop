package com.github.ityeri.comshop.dsl

import com.github.ityeri.comshop.ComshopFactory
import com.github.ityeri.comshop.internal.node.ChainNode
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.SingleNode
import com.github.ityeri.comshop.internal.node.UnionNode
import com.github.ityeri.comshop.internal.node.type.AbstractArgumentNodeType

@ComshopDSL
class ArgumentListDSL<S> {
    internal val nodes: MutableList<Node<AbstractArgumentNodeType<S, *>>> = mutableListOf()

    infix fun <T> String.to(argumentType: ComshopArgumentType<T>) {
        nodes.add(SingleNode(
            ComshopFactory.createArgumentNodeType(this, argumentType)
        ))
    }

    infix fun <T> String.to(block: () -> ComshopArgumentType<T>) {
        nodes.add(SingleNode(
            ComshopFactory.createArgumentNodeType(this, block())
        ))
    }

    fun then(block: ArgumentListDSL<S>.() -> Unit) {
        val dsl = ArgumentListDSL<S>().apply(block)
        nodes.add(dsl.buildChainNode())
    }

    fun union(block: ArgumentListDSL<S>.() -> Unit) {
        val dsl = ArgumentListDSL<S>().apply(block)
        nodes.add(dsl.buildUnionNode())
    }

    fun buildChainNode(): ChainNode<AbstractArgumentNodeType<S, *>> {
        return ChainNode(nodes)
    }
    fun buildUnionNode(): UnionNode<AbstractArgumentNodeType<S, *>> {
        return UnionNode(nodes)
    }
}