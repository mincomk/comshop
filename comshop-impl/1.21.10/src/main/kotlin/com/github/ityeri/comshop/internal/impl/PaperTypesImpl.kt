package com.github.ityeri.comshop.internal.impl

import com.destroystokyo.paper.profile.PlayerProfile
import com.github.ityeri.comshop.internal.argument.ComshopArgumentType
import com.github.ityeri.comshop.internal.entry.AbstractPaperTypes
import com.google.common.collect.Range
import io.papermc.paper.command.brigadier.argument.position.ColumnBlockPosition
import io.papermc.paper.command.brigadier.argument.position.ColumnFinePosition
import io.papermc.paper.command.brigadier.argument.predicate.BlockInWorldPredicate
import io.papermc.paper.command.brigadier.argument.predicate.ItemStackPredicate
import io.papermc.paper.entity.LookAnchor
import io.papermc.paper.math.BlockPosition
import io.papermc.paper.math.FinePosition
import io.papermc.paper.math.Rotation
import io.papermc.paper.registry.RegistryKey
import io.papermc.paper.registry.TypedKey
import net.kyori.adventure.chat.SignedMessage
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Axis
import org.bukkit.GameMode
import org.bukkit.HeightMap
import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.block.BlockState
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.scoreboard.Criteria
import org.bukkit.scoreboard.DisplaySlot
import java.util.UUID


class PaperTypesImpl : AbstractPaperTypes {
    override fun entity(): ComshopArgumentType<Entity> = TODO()
    override fun entities(): ComshopArgumentType<Collection<Entity>> = TODO()
    override fun player(): ComshopArgumentType<Player> = TODO()
    override fun players(): ComshopArgumentType<Collection<Player>> = TODO()
    override fun playerProfiles(): ComshopArgumentType<Collection<PlayerProfile>> = TODO()
    override fun blockPosition(): ComshopArgumentType<BlockPosition> = TODO()
    override fun columnBlockPosition(): ComshopArgumentType<ColumnBlockPosition> = TODO()
    override fun blockInWorldPredicate(): ComshopArgumentType<BlockInWorldPredicate> = TODO()
    override fun finePosition(centered: Boolean): ComshopArgumentType<FinePosition> = TODO()
    override fun columnFinePosition(centered: Boolean): ComshopArgumentType<ColumnFinePosition> = TODO()
    override fun rotation(): ComshopArgumentType<Rotation> = TODO()
    override fun angle(): ComshopArgumentType<Float> = TODO()
    override fun axis(): ComshopArgumentType<Axis> = TODO()
    override fun blockState(): ComshopArgumentType<BlockState> = TODO()
    override fun itemStack(): ComshopArgumentType<ItemStack> = TODO()
    override fun itemPredicate(): ComshopArgumentType<ItemStackPredicate> = TODO()
    override fun namedColor(): ComshopArgumentType<NamedTextColor> = TODO()
    override fun hexColor(): ComshopArgumentType<TextColor> = TODO()
    override fun component(): ComshopArgumentType<Component> = TODO()
    override fun style(): ComshopArgumentType<Style> = TODO()
    override fun signedResolver(): ComshopArgumentType<SignedMessage> = TODO()
    override fun scoreboardDisplaySlot(): ComshopArgumentType<DisplaySlot> = TODO()
    override fun namespacedKey(): ComshopArgumentType<NamespacedKey> = TODO()
    override fun key(): ComshopArgumentType<Key> = TODO()
    override fun integerRange(): ComshopArgumentType<Range<Int>> = TODO()
    override fun doubleRange(): ComshopArgumentType<Range<Double>> = TODO()
    override fun world(): ComshopArgumentType<World> = TODO()
    override fun gameMode(): ComshopArgumentType<GameMode> = TODO()
    override fun heightMap(): ComshopArgumentType<HeightMap> = TODO()
    override fun uuid(): ComshopArgumentType<UUID> = TODO()
    override fun objectiveCriteria(): ComshopArgumentType<Criteria> = TODO()
    override fun entityAnchor(): ComshopArgumentType<LookAnchor> = TODO()
    override fun time(minTime: Int): ComshopArgumentType<Int> = TODO()
    override fun templateMirror(): ComshopArgumentType<Mirror> = TODO()
    override fun templateRotation(): ComshopArgumentType<StructureRotation> = TODO()
    override fun <T: Any> resource(registryKey: RegistryKey<T>): ComshopArgumentType<T> = TODO()
    override fun <T: Any> resourceKey(registerKey: RegistryKey<T>): ComshopArgumentType<TypedKey<T>> = TODO()
}