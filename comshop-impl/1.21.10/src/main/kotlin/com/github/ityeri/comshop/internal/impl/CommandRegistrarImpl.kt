package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.CommandNodeType
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin

class CommandRegistrarImpl : AbstractCommandRegistrar {
    val nodes: MutableList<Node<CommandNodeType>> = mutableListOf()
    override fun init(plugin: JavaPlugin) {
        plugin.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { commands ->
            for (node in nodes) {
//                val boundary = createBoundary(node)
            }
        }
    }

    override fun register(node: Node<CommandNodeType>) {
        nodes.add(node)
    }
}