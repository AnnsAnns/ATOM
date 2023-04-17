package eu.tomger.blocks;

import eu.tomger.blocks.cornplant.Corn;
import eu.tomger.blocks.cornplant.CornFirst;
import eu.tomger.blocks.cornplant.CornSecond;
import eu.tomger.blocks.tomatoplant.FinalStage;
import eu.tomger.blocks.tomatoplant.FirstStage;
import eu.tomger.blocks.tomatoplant.SecondStage;
import eu.tomger.blocks.tomatoplant.ThirdStage;
import eu.tomger.items.AtomItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.shape.VoxelShape;

public class AtomBlocks {
    private static final AbstractBlock.Settings settings = AbstractBlock.Settings.of(Material.PLANT).nonOpaque().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP);

    public static final CropBlock CORN_CROP_BLOCK = new GenericPlant(settings, AtomItems.CORN_SEED, new VoxelShape[]{
            CornFirst.makeShape(),
            CornSecond.makeShape(),
            CornSecond.makeShape(),
            Corn.makeShape(),
    });

    public static final CropBlock TOMATO_CROP_BLOCK = new GenericPlant(settings, AtomItems.CORN_SEED, new VoxelShape[]{
            FirstStage.makeShape(),
            SecondStage.makeShape(),
            ThirdStage.makeShape(),
            FinalStage.makeShape()
    });
}
