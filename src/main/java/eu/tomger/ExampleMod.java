package eu.tomger;

import eu.tomger.items.Tomato;
import eu.tomger.items.TomatoPlant;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
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
	public static final Item TOMATO = new Tomato(new FabricItemSettings().food(FoodComponents.APPLE));
	public static final Item TOMATO_SEED = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("atom", "atom"))
			.icon(() -> new ItemStack(TOMATO))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.ITEM, new Identifier("atom", "tomato"), TOMATO);
		Registry.register(Registries.BLOCK, new Identifier("atom", "tomato_plant"), TOMATO_CROP_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("atom", "tomato_seed"), TOMATO_SEED);

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(TOMATO);
			content.add(TOMATO_CROP_BLOCK);
			content.add(TOMATO_SEED);
		});
	}
}