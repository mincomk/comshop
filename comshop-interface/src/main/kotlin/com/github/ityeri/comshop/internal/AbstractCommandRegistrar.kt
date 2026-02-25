package com.github.ityeri.comshop.internal

import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.NodeType
import org.bukkit.plugin.java.JavaPlugin

interface AbstractCommandRegistrar<S> {
    fun init(plugin: JavaPlugin)
    fun register(node: Node<NodeType<S>>)
}