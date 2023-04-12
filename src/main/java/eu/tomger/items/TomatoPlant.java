package eu.tomger.items;

import eu.tomger.ExampleMod;
import eu.tomger.blocks.tomatoplant.FinalStage;
import eu.tomger.blocks.tomatoplant.FirstStage;
import eu.tomger.blocks.tomatoplant.SecondStage;
import eu.tomger.blocks.tomatoplant.ThirdStage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TomatoPlant extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            FirstStage.makeShape(),
            SecondStage.makeShape(),
            ThirdStage.makeShape(),
            FinalStage.makeShape()
    };

    public TomatoPlant(Settings settings) {
        super(settings);
    }

    public ItemConvertible getSeedsItem() {
        return ExampleMod.TOMATO;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())%4];
    }
}
