package com.github.ityeri.comshop.internal.entry

import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.CommandNodeType
import org.bukkit.plugin.java.JavaPlugin

interface AbstractCommandRegistrar {
    fun init(plugin: JavaPlugin)
    fun register(node: Node<CommandNodeType>)
}
