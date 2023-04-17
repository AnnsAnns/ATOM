package eu.tomger.items;

import eu.tomger.blocks.AtomBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

public class AtomItems {
    public static final Item TOMATO = new Tomato(new FabricItemSettings().food(FoodComponents.APPLE));
    public static final Item CORN = new Corn(new FabricItemSettings().food(FoodComponents.CARROT));
    public static final Item TOMATO_SEED = new AliasedBlockItem(AtomBlocks.TOMATO_CROP_BLOCK, new Item.Settings());
    public static final Item CORN_SEED = new AliasedBlockItem(AtomBlocks.CORN_CROP_BLOCK, new Item.Settings());
}
