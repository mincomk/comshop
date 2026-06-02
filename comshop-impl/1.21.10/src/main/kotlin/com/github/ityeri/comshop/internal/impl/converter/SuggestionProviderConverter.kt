package com.github.ityeri.comshop.internal.impl.converter

import com.github.ityeri.comshop.internal.CommandWritingContext
import com.github.ityeri.comshop.internal.node.ComshopSuggestionProvider
import com.mojang.brigadier.suggestion.SuggestionProvider
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.MessageComponentSerializer
import net.kyori.adventure.text.Component


fun toBrigadierSuggestionProvider(
    suggestionProvider: ComshopSuggestionProvider
): SuggestionProvider<CommandSourceStack> =
    SuggestionProvider<CommandSourceStack> { context, builder ->
        suggestionProvider(
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

        builder.buildFuture()
    }
