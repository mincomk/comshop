package com.github.ityeri.comshop

import com.github.ityeri.comshop.internal.node.type.AbstractCommandNodeType
import com.mojang.brigadier.context.CommandContext

class CommandNodeType<S>(
    name: String, commandBlock: (source: CommandContext<S>) -> Unit, permissionChecker: (source: S) -> Boolean
): AbstractCommandNodeType<S> by ComshopFactory.createCommandNodeType(name, commandBlock, permissionChecker)