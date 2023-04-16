package eu.tomger;

import eu.tomger.items.Corn;
import eu.tomger.items.CornPlant;
import eu.tomger.items.Tomato;
import eu.tomger.items.TomatoPlant;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("atom");

	public static final CropBlock TOMATO_CROP_BLOCK = new TomatoPlant(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final CropBlock CORN_CROP_BLOCK = new CornPlant(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item TOMATO = new Tomato(new FabricItemSettings().food(FoodComponents.APPLE));
	public static final Item CORN = new Corn(new FabricItemSettings().food(FoodComponents.CARROT));
	public static final Item TOMATO_SEED = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());

	public static final Item CORN_SEED = new AliasedBlockItem(CORN_CROP_BLOCK, new Item.Settings());
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("atom", "atom"))
			.icon(() -> new ItemStack(TOMATO))
			.build();

	private static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.ITEM, new Identifier("atom", "tomato"), TOMATO);
		Registry.register(Registries.BLOCK, new Identifier("atom", "tomato_plant"), TOMATO_CROP_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("atom", "tomato_seed"), TOMATO_SEED);
		Registry.register(Registries.ITEM, new Identifier("atom", "corn"), CORN);
		Registry.register(Registries.ITEM, new Identifier("atom", "corn_seed"), CORN_SEED);
		Registry.register(Registries.BLOCK, new Identifier("atom", "corn_plant"), CORN_CROP_BLOCK);

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(TOMATO);
			content.add(TOMATO_CROP_BLOCK);
			content.add(TOMATO_SEED);
			content.add(CORN);
			content.add(CORN_SEED);
			content.add(CORN_CROP_BLOCK);
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && GRASS_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.conditionally(RandomChanceLootCondition.builder(0.2f))
						.rolls(UniformLootNumberProvider.create(0, 1))
						.with(ItemEntry.builder(TOMATO_SEED))
						.with(ItemEntry.builder(CORN_SEED));

				tableBuilder.pool(poolBuilder);
			}
		});
	}
}