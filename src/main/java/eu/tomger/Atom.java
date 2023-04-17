package eu.tomger;

import eu.tomger.items.Corn;
import eu.tomger.items.CornPlant;
import eu.tomger.items.Tomato;
import eu.tomger.items.TomatoPlant;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;

import static eu.tomger.Helpers.registerVeg;

public class Atom implements ModInitializer {
	public static final CropBlock TOMATO_CROP_BLOCK = new TomatoPlant(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final CropBlock CORN_CROP_BLOCK = new CornPlant(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item TOMATO = new Tomato(new FabricItemSettings().food(FoodComponents.APPLE));
	public static final Item CORN = new Corn(new FabricItemSettings().food(FoodComponents.CARROT));
	public static final Item TOMATO_SEED = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());
	public static final Item CORN_SEED = new AliasedBlockItem(CORN_CROP_BLOCK, new Item.Settings());
	public static final String MODNAME = "atom";

	@Override
	public void onInitialize() {
		registerVeg("tomato", TOMATO, TOMATO_SEED, TOMATO_CROP_BLOCK);
		registerVeg("corn", CORN, CORN_SEED, CORN_CROP_BLOCK);
	}
}