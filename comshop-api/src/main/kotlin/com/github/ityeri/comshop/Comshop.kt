package com.github.ityeri.comshop

import com.github.ityeri.comshop.builder.CommandBuilder


fun command(name: String, block: CommandBuilder.() -> Unit): CommandBuilder {
    return CommandBuilder(name).apply(block)
}
