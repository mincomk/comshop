package com.github.ityeri.comshop.contract.argument

import com.github.ityeri.comshop.contract.CommandWritingContext
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class ComshopCustomArgumentType<T : Any, N : Any>(val nativeArgumentType: NativeArgumentType<N>) : ComshopArgumentType<T> {
    abstract fun parse(nativeValue: N, source: CommandSourceStack): T
    abstract fun suggest(writingContext: CommandWritingContext, source: CommandSourceStack): Iterable<SuggestionElement>
}
