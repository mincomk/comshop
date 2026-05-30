package com.github.ityeri.comshop.internal.impl

import com.github.ityeri.comshop.internal.argument.NativeArgumentType
import com.mojang.brigadier.StringReader
import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.Suggestions
import com.mojang.brigadier.suggestion.SuggestionsBuilder
import io.papermc.paper.command.brigadier.argument.CustomArgumentType
import java.util.concurrent.CompletableFuture


open class BaseCustomArgumentType<T : Any, N : Any>(
    override val nativeArgumentType: NativeArgumentType<N>
) : AbstractCustomArgumentType<T, N> {
    override fun parse(reader: StringReader): T {
        throw NotImplementedError()
    }

    override fun <S> suggests(
        context: CommandContext<S>,
        remineText: String
    ): Collection<String> {
        throw NotImplementedError()
    }

    override fun build(): ArgumentType<T> {
        return object : CustomArgumentType<T, N> {
            override fun parse(reader: StringReader): T {
                return this@BaseCustomArgumentType.parse(reader)
            }

            override fun getNativeType(): ArgumentType<N> {
                return nativeArgumentType.build()
            }

            override fun <S : Any> listSuggestions(
                context: CommandContext<S>,
                builder: SuggestionsBuilder
            ): CompletableFuture<Suggestions> {
                this@BaseCustomArgumentType.suggests(context, builder.remaining).forEach { text ->
                    builder.suggest(text)
                }

                return builder.buildFuture()
            }
        }
    }
}