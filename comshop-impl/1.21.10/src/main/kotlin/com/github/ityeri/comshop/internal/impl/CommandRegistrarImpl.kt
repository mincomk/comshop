package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.NodeType
import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin

class CommandRegistrarImpl : AbstractCommandRegistrar<CommandSourceStack> {
    val nodes: MutableList<Node<NodeType<CommandSourceStack>>> = mutableListOf()

    override fun init(plugin: JavaPlugin) {
        plugin.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { commands ->
            for (node in nodes) {
                val boundary = createBoundary(node)
                commands.registrar().register(boundary.entries.first().build() as LiteralCommandNode)
            }
        }
    }

    override fun register(node: Node<NodeType<CommandSourceStack>>) {
        nodes.add(node)
    }
}
