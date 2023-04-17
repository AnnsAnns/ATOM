package eu.tomger;

import net.fabricmc.api.ModInitializer;

import static eu.tomger.Helpers.registerVeg;
import static eu.tomger.blocks.AtomBlocks.*;
import static eu.tomger.items.AtomItems.*;

public class Atom implements ModInitializer {
	public static final String MODNAME = "atom";

	@Override
	public void onInitialize() {
		registerVeg("tomato", TOMATO, TOMATO_SEED, TOMATO_CROP_BLOCK);
		registerVeg("corn", CORN, CORN_SEED, CORN_CROP_BLOCK);
	}
}