package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.AbstractCommandRegistrar
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.node.Node
import com.github.ityeri.comshop.internal.node.type.NodeType
import io.papermc.paper.command.brigadier.CommandSourceStack
import org.bukkit.plugin.java.JavaPlugin

object CommandRegistrar : AbstractCommandRegistrar<CommandSourceStack> {
    private val registrar = ComshopBootstrapper.loader!!.loadRegistrar()

    override fun init(plugin: JavaPlugin) {
        registrar.init(plugin)
    }

    override fun register(node: Node<NodeType<CommandSourceStack>>) {
        registrar.register(node)
    }
}