package eu.tomger;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static eu.tomger.Atom.*;

public class Helpers {

    private static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("atom", "atom"))
            .icon(() -> new ItemStack(TOMATO))
            .build();

    static void addContentToGroup(ItemConvertible entry) {
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(entry);
        });
    }

    static void addToLootTable(Identifier table, ItemConvertible item) {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && table.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .rolls(UniformLootNumberProvider.create(0, 1))
                        .with(ItemEntry.builder(item));

                tableBuilder.pool(poolBuilder);
            }
        });
    }

    static void registerVeg(String path, Item item, Item seed, CropBlock plant) {
        Registry.register(Registries.ITEM, new Identifier(MODNAME, path), item);
        Registry.register(Registries.BLOCK, new Identifier(MODNAME, path+"_plant"), plant);
        Registry.register(Registries.ITEM, new Identifier(MODNAME, path+"_seed"), seed);

        addContentToGroup(item);
        addContentToGroup(seed);
        addContentToGroup(plant);

        addToLootTable(GRASS_LOOT_TABLE_ID, seed);
    }
}
