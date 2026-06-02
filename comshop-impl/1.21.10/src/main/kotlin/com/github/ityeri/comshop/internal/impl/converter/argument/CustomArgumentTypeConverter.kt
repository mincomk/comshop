package com.github.ityeri.comshop.internal.impl.converter.argument

import com.github.ityeri.comshop.internal.CommandWritingContext
import com.github.ityeri.comshop.internal.argument.ComshopCustomArgumentType
import com.mojang.brigadier.StringReader
import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.Suggestions
import com.mojang.brigadier.suggestion.SuggestionsBuilder
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.MessageComponentSerializer
import io.papermc.paper.command.brigadier.argument.CustomArgumentType
import net.kyori.adventure.text.Component
import java.util.concurrent.CompletableFuture


fun <T : Any, N : Any> convertCustomArgumentType(argumentType: ComshopCustomArgumentType<T, N>): ArgumentType<T> =
    object : CustomArgumentType<T, N> {
        override fun parse(reader: StringReader): T {
            throw NotImplementedError(
                "The ComshopCustomArgumentType does not support parsing without a source value"
            )
        }

        override fun <S : Any> parse(reader: StringReader, source: S): T =
            when (source) {
                is CommandSourceStack -> {
                    argumentType.parse(nativeType.parse(reader, source), source)
                }
                else -> {
                    throw NotImplementedError(
                        "The ComshopCustomArgumentType only support a CommandSourceStack as source value"
                    )
                }
            }

        override fun <S : Any> listSuggestions(
            context: CommandContext<S>,
            builder: SuggestionsBuilder
        ): CompletableFuture<Suggestions> {
            if (context.source !is CommandSourceStack) {
                throw NotImplementedError(
                    "The ComshopCustomArgumentType only support a CommandSourceStack as source value"
                )
            }

            argumentType.suggest(
                CommandWritingContext(builder.input, builder.start),
                context.source as CommandSourceStack
            ).forEach { suggestionElement ->
                if (suggestionElement.tooltipMessage == null) {
                    builder.suggest(suggestionElement.text)
                } else {
                    builder.suggest(
                        suggestionElement.text,
                        MessageComponentSerializer.message()
                            .serialize(suggestionElement.tooltipMessage as Component)
                    )
                }
            }

            return builder.buildFuture()
        }

        override fun getNativeType(): ArgumentType<N> = convertNativeArgumentType(argumentType.nativeArgumentType)
    }
