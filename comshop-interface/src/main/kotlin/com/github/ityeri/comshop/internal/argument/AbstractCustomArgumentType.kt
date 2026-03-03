package com.github.ityeri.comshop.internal.argument

import com.mojang.brigadier.StringReader
import com.mojang.brigadier.context.CommandContext

interface CustomArgumentType<T, N> {
    val nativeArgumentType: NativeArgumentType<N>

    fun parse(reader: StringReader): T
    fun <S> suggests(context: CommandContext<S>, remineText: String): Collection<String>
}