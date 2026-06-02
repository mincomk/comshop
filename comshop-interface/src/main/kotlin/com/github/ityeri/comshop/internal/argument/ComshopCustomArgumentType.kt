package com.github.ityeri.comshop.internal.argument

import com.github.ityeri.comshop.internal.CommandWritingContext
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class ComshopCustomArgumentType<T, N>(val nativeArgumentType: NativeArgumentType<N>) : ComshopArgumentType<T> {
    abstract fun parse(nativeValue: N, source: CommandSourceStack): T
    abstract fun suggest(writingContext: CommandWritingContext, source: CommandSourceStack): Iterable<SuggestionElement>
}
