package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.NodeType
import org.bukkit.plugin.java.JavaPlugin

class CommandRegistrarImpl<S> : AbstractCommandRegistrar<S> {
    override fun init(plugin: JavaPlugin) {
        TODO("Not yet implemented")
    }

    override fun register(node: Node<NodeType<S>>) {
        TODO("Not yet implemented")
    }
}