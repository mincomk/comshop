package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.entry.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.ComshopCommandNode
import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin


class CommandRegistrarImpl : AbstractCommandRegistrar {
    val nodes: MutableList<Node<ComshopCommandNode>> = mutableListOf()

    override fun init(plugin: JavaPlugin) {
        plugin.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val commands = event.registrar()

            for (node in nodes) {
                val convertedNode = convertToArgumentBuilderNode(node)
                val boundary = connectArgumentBuilders(convertedNode)

                if (boundary.entries.size != 1) {
                    throw IllegalArgumentException("??")
                }

                commands.register(boundary.entries.first().build() as LiteralCommandNode<CommandSourceStack>)
            }
        }
    }

    override fun register(node: Node<ComshopCommandNode>) {
        nodes.add(node)
    }
}
