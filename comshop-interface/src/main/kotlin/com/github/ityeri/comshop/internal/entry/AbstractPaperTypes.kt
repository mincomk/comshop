package com.github.ityeri.comshop.internal.entry

import com.destroystokyo.paper.profile.PlayerProfile
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.google.common.collect.Range
import io.papermc.paper.command.brigadier.argument.ArgumentTypes
import io.papermc.paper.command.brigadier.argument.position.ColumnBlockPosition
import io.papermc.paper.command.brigadier.argument.position.ColumnFinePosition
import io.papermc.paper.command.brigadier.argument.predicate.BlockInWorldPredicate
import io.papermc.paper.command.brigadier.argument.predicate.ItemStackPredicate
import io.papermc.paper.math.BlockPosition
import io.papermc.paper.math.FinePosition
import io.papermc.paper.math.Rotation
import io.papermc.paper.entity.LookAnchor
import io.papermc.paper.registry.RegistryKey
import io.papermc.paper.registry.TypedKey
import net.kyori.adventure.chat.SignedMessage
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import org.bukkit.*
import org.bukkit.block.BlockState
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.scoreboard.Criteria
import org.bukkit.scoreboard.DisplaySlot
import java.util.*

interface AbstractPaperTypes {
    fun entity(): ComshopArgumentType<Entity>
    fun entities(): ComshopArgumentType<Collection<Entity>>
    fun player(): ComshopArgumentType<Player>
    fun players(): ComshopArgumentType<Collection<Player>>
    fun playerProfiles(): ComshopArgumentType<Collection<PlayerProfile>>
    fun blockPosition(): ComshopArgumentType<BlockPosition>
    fun columnBlockPosition(): ComshopArgumentType<ColumnBlockPosition>
    fun blockInWorldPredicate(): ComshopArgumentType<BlockInWorldPredicate>
    fun finePosition(centered: Boolean = false): ComshopArgumentType<FinePosition>
    fun columnFinePosition(centered: Boolean = false): ComshopArgumentType<ColumnFinePosition>
    fun rotation(): ComshopArgumentType<Rotation>
    fun angle(): ComshopArgumentType<Float>
    fun axis(): ComshopArgumentType<Axis>
    fun blockState(): ComshopArgumentType<BlockState>
    fun itemStack(): ComshopArgumentType<ItemStack>
    fun itemPredicate(): ComshopArgumentType<ItemStackPredicate>
    fun namedColor(): ComshopArgumentType<NamedTextColor>
    fun hexColor(): ComshopArgumentType<TextColor>
    fun component(): ComshopArgumentType<Component>
    fun style(): ComshopArgumentType<Style>
    fun signedResolver(): ComshopArgumentType<SignedMessage>
    fun scoreboardDisplaySlot(): ComshopArgumentType<DisplaySlot>
    fun namespacedKey(): ComshopArgumentType<NamespacedKey>
    fun key(): ComshopArgumentType<Key>
    fun integerRange(): ComshopArgumentType<Range<Int>>
    fun doubleRange(): ComshopArgumentType<Range<Double>>
    fun world(): ComshopArgumentType<World>
    fun gameMode(): ComshopArgumentType<GameMode>
    fun heightMap(): ComshopArgumentType<HeightMap>
    fun uuid(): ComshopArgumentType<UUID>
    fun objectiveCriteria(): ComshopArgumentType<Criteria>
    fun entityAnchor(): ComshopArgumentType<LookAnchor>
    fun time(minTime: Int): ComshopArgumentType<Int>
    fun templateMirror(): ComshopArgumentType<Mirror>
    fun templateRotation(): ComshopArgumentType<StructureRotation>
    fun <T: Any> resource(registryKey: RegistryKey<T>): ComshopArgumentType<T>
    fun <T: Any> resourceKey(registerKey: RegistryKey<T>): ComshopArgumentType<TypedKey<T>>
}