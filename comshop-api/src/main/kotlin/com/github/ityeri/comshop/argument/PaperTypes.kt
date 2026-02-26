package com.github.ityeri.comshop.argument

import com.destroystokyo.paper.profile.PlayerProfile
import com.github.ityeri.comshop.ComshopBootstrapper
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

object PaperTypes : AbstractPaperTypes {
    private val types = ComshopBootstrapper.loader!!.loadPaperTypes()

    override fun entity(): ComshopArgumentType<Entity> = types.entity()
    override fun entities(): ComshopArgumentType<Collection<Entity>> = types.entities()
    override fun player(): ComshopArgumentType<Player> = types.player()
    override fun players(): ComshopArgumentType<Collection<Player>> = types.players()
    override fun playerProfiles(): ComshopArgumentType<Collection<PlayerProfile>> = types.playerProfiles()
    override fun blockPosition(): ComshopArgumentType<BlockPosition> = types.blockPosition()
    override fun columnBlockPosition(): ComshopArgumentType<ColumnBlockPosition> = types.columnBlockPosition()
    override fun blockInWorldPredicate(): ComshopArgumentType<BlockInWorldPredicate> = types.blockInWorldPredicate()
    override fun finePosition(centered: Boolean): ComshopArgumentType<FinePosition> = types.finePosition()
    override fun columnFinePosition(centered: Boolean): ComshopArgumentType<ColumnFinePosition> =
        types.columnFinePosition()
    override fun rotation(): ComshopArgumentType<Rotation> = types.rotation()
    override fun angle(): ComshopArgumentType<Float> = types.angle()
    override fun axis(): ComshopArgumentType<Axis> = types.axis()
    override fun blockState(): ComshopArgumentType<BlockState> = types.blockState()
    override fun itemStack(): ComshopArgumentType<ItemStack> = types.itemStack()
    override fun itemPredicate(): ComshopArgumentType<ItemStackPredicate> = types.itemPredicate()
    override fun namedColor(): ComshopArgumentType<NamedTextColor> = types.namedColor()
    override fun hexColor(): ComshopArgumentType<TextColor> = types.hexColor()
    override fun component(): ComshopArgumentType<Component> = types.component()
    override fun style(): ComshopArgumentType<Style> = types.style()
    override fun signedResolver(): ComshopArgumentType<SignedMessage> = types.signedResolver()
    override fun scoreboardDisplaySlot(): ComshopArgumentType<DisplaySlot> = types.scoreboardDisplaySlot()
    override fun namespacedKey(): ComshopArgumentType<NamespacedKey> = types.namespacedKey()
    override fun key(): ComshopArgumentType<Key> = types.key()
    override fun integerRange(): ComshopArgumentType<Range<Int>> = types.integerRange()
    override fun doubleRange(): ComshopArgumentType<Range<Double>> = types.doubleRange()
    override fun world(): ComshopArgumentType<World> = types.world()
    override fun gameMode(): ComshopArgumentType<GameMode> = types.gameMode()
    override fun heightMap(): ComshopArgumentType<HeightMap> = types.heightMap()
    override fun uuid(): ComshopArgumentType<UUID> = types.uuid()
    override fun objectiveCriteria(): ComshopArgumentType<Criteria> = types.objectiveCriteria()
    override fun entityAnchor(): ComshopArgumentType<LookAnchor> = types.entityAnchor()
    override fun time(minTime: Int): ComshopArgumentType<Int> = types.time(minTime)
    override fun templateMirror(): ComshopArgumentType<Mirror> = types.templateMirror()
    override fun templateRotation(): ComshopArgumentType<StructureRotation> = types.templateRotation()
    override fun <T: Any> resource(registryKey: RegistryKey<T>): ComshopArgumentType<T> = types.resource(registryKey)
    override fun <T: Any> resourceKey(registerKey: RegistryKey<T>): ComshopArgumentType<TypedKey<T>> =
        types.resourceKey(registerKey)
}